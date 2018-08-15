package com.hamster.ak.impl;

import com.hamster.ak.api.LiabilityAccount;
import com.hamster.ak.api.LiabilityAccountCreation;
import com.hamster.ak.api.LiabilityAccountService;
import com.hamster.ak.bean.LiabilityAccountBean;
import com.hamster.ak.common.bean.ThreadLocalUser;
import com.hamster.ak.common.exception.HmException;
import com.hamster.ak.mapper.LiabilityAccountMapper;
import com.hamster.ak.transfer.LiabilityAccountTransfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class LiabilityAccountServiceImpl implements LiabilityAccountService {

    @Autowired
    private LiabilityAccountMapper liabilityAccountMapper;

    @Autowired
    private LiabilityAccountTransfer liabilityAccountTransfer;

    @Override
    public Integer create(LiabilityAccountCreation creation) {

        Optional.ofNullable(liabilityAccountMapper.selectByUserIdAndName(ThreadLocalUser.getUser().getId(),
                creation.getName())).ifPresent(account -> {
            log.error("已存在负债账户: " + account.toString());
            throw new HmException("当前负债账户已存在");
        });

        return Optional.ofNullable(liabilityAccountMapper.insert(liabilityAccountTransfer
                .transferTOLiabilityAccountBean(creation))).orElseThrow(() -> new HmException("新增负债账户失败"));
    }

    @Override
    public void update(LiabilityAccount account) {

    }

    @Override
    public void delete(String accountId) {

    }

    @Override
    public List<LiabilityAccount> getAccounts() {
        return null;
    }

    @Override
    public LiabilityAccount getAccountById(Integer id) {

        return liabilityAccountTransfer.transferTOLiabilityAccount(
                Optional.ofNullable(liabilityAccountMapper.selectById(id)).orElseThrow(() ->
                        new HmException("当前负债账户不存在")));
    }
}
