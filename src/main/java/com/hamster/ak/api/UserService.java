package com.hamster.ak.api;

import com.hamster.ak.common.exception.HmException;
import com.hamster.ak.common.bean.Page;

public interface UserService {

    /**
     * 创建用户，返回用户ID
     *
     * @param userCreation not null
     *
     * @return userId
     *
     * @throws HmException
     */
    Integer create(UserCreation userCreation);

    /**
     * 根据用户id 查询用户
     *
     * @param id not null
     *
     * @return user
     */
    User getUserById(Integer id);

    /**
     * 用户登陆验证
     *
     * @param credential 登陆凭证 not null
     *
     * @return LoginResult 登陆验证结果
     */
    LoginResult login(UserCredential credential);

    /**
     * 更改密码
     *
     * @param userId not null
     *
     * @param oldPassword not null
     *
     * @param newPassword not null
     *
     * @throws HmException
     */
    void changePassword(Integer userId, String oldPassword, String newPassword);

    /**
     * 删W除用户
     *
     * @param userId not null
     */
    void delete(Integer userId);

    /**
     *
     * @param filter 过滤器 not null
     *
     * @param page 页码 >1
     *
     * @param pageSize 分页大小 范围[1, 100]
     *
     * @param sortKey 排序字段
     *
     * @param desc 是否倒叙排列
     *
     * @return 分页查询结果
     */
    Page<User> query(UserFilter filter, int page, int pageSize, String sortKey, boolean desc);



}
