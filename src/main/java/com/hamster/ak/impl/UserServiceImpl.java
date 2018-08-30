package com.hamster.ak.impl;

import com.hamster.ak.api.*;
import com.hamster.ak.bean.UserBean;
import com.hamster.ak.common.bean.Page;
import com.hamster.ak.common.bean.ThreadLocalUser;
import com.hamster.ak.common.config.HamsterTx;
import com.hamster.ak.common.config.HmProperties;
import com.hamster.ak.common.config.ModelConstant;
import com.hamster.ak.common.exception.HmException;
import com.hamster.ak.common.web.WebSocketServer;
import com.hamster.ak.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

import static com.hamster.ak.common.exception.HmError.*;

@Slf4j
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HmProperties hmProperties;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private LiabilityAccountService liabilityAccountService;

    @Autowired
    private WebSocketServer webSocketServer;

    @Override
    public Integer create(UserCreation userCreation) {

        Optional.ofNullable(userMapper.selectByLoginName(userCreation.getLoginName())).ifPresent(u -> {
            log.error("用户(loginName)" + u.getLoginName() + "已存在");
            throw new HmException(USER_EXISTED);
        });

        UserBean userBean = UserBean.builder()
                .loginName(userCreation.getLoginName())
                .name(userCreation.getName())
                .password(userCreation.getPassword())
                .creator(userCreation.getName())
                .modifier(userCreation.getName())
                .build();

        if (userMapper.insert(userBean) != 1) {
            log.error("新建用户(loginName)" + userCreation.getLoginName() + "失败，插入条数不为1");
            throw new HmException(ADD_FAIL);
        }

        return userMapper.selectByLoginName(userCreation.getLoginName()).getId();
    }

    @Override
    public User getUserById(Integer id) {
        return Optional.ofNullable(userMapper.selectById(id)).map(userBean ->
                User.builder().id(userBean.getId()).name(userBean.getName())
                        .loginName(userBean.getLoginName())
                        .password(userBean.getPassword())
                        .created(userBean.getCreated())
                        .modified(userBean.getModified())
                        .modifier(userBean.getModifier())
                        .creator(userBean.getCreator())
                        .created(userBean.getCreated()).build()
        ).orElseThrow(() -> new HmException(USER_NOT_EXIST));
    }

    @Override
    public LoginResult login(UserCredential credential) {

        UserBean userBean = userMapper.selectByLoginName(credential.getLoginName());
        Optional.ofNullable(userBean).orElseThrow(() -> new HmException(USER_NOT_EXIST));

        if (!userBean.getPassword().equals(credential.getPassword())) {
            log.error("密码错误");
            throw new HmException(PASSWORD_WRONG);
        }

        String token = tokenService.encodeToken(Token.builder()
                .userId(userBean.getId())
                .userName(userBean.getName())
                .expiration(DateUtils.addHours(new Date(), hmProperties.getExpiryTime())).build());
        try {
            liabilityAccountService.remind(userBean.getId());
        } catch (Exception e) {
            log.error("用户登录后提醒失败");
            e.printStackTrace();
        }
        return LoginResult.builder().userId(userBean.getId())
                .loginName(userBean.getLoginName())
                .accepted(true)
                .message(ModelConstant.LOGIN_SUCCESS)
                .token(token)
                .build();
    }

    @Override
    public void loginOut() {
        User user = Optional.ofNullable(ThreadLocalUser.getUser()).orElseThrow(() -> new HmException(USER_NOT_LOGIN));
        webSocketServer.onClose();
    }

    @Override
    @HamsterTx
    public void changePassword(UserChangePasswordForm form) {
        Optional.of(ThreadLocalUser.getUser()).ifPresent(user -> {
            if (!user.getId().equals(form.getUserId())) {
                log.error("用户身份信息不匹配， LocalUser: [" + user.getId() + user.getName() +
                        "], request User: [ id = " + form.getUserId() + "]");
                throw new HmException(USER_NOT_LOGIN);
            }
        });
        UserBean userBean = Optional.ofNullable(userMapper.selectById(form.getUserId())).orElseThrow(() ->
                new HmException(USER_NOT_EXIST));

        // FIXME @yanwenbo 这里可以把用户密码解密出明文

        if (!form.getOldPassword().equals(userBean.getPassword())) {
            log.error("密码错误,oldPassword: " + userBean.getPassword() + ", inputPassword: " + form.getOldPassword());
            throw new HmException(PASSWORD_WRONG);
        }
        if (userMapper.updatePassword(form.getUserId(), form.getNewPassword(), userBean.getName()) != 1) {
            throw new HmException(UPDATE_FAIL);
        }
    }

    @Override
    public void delete(Integer userId) {

    }

    @Override
    public Page<User> query(UserFilter filter, int page, int pageSize, String sortKey, boolean desc) {
        return null;
    }
}
