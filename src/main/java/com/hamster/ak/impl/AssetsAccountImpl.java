package com.hamster.ak.impl;

import com.google.common.collect.Lists;
import com.hamster.ak.api.*;
import com.hamster.ak.common.bean.ThreadLocalUser;
import com.hamster.ak.common.exception.HmException;
import com.hamster.ak.transfer.AssetsAccountTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.hamster.ak.common.exception.HmError.USER_NOT_EXIST;

@Component
public class AssetsAccountImpl implements AssetsAccountService {

    @Autowired
    private LiabilityAccountService liabilityAccountService;

    @Autowired
    private AssetsAccountTransfer assetsAccountTransfer;

    @Override
    public String create(AssetsAccountCreation creation) {
        return null;
    }

    @Override
    public void update(AssetsAccount assetsAccount) {

    }

    @Override
    public void delete(String accountId) {

    }

    @Override
    public List<AssetsAccount> getAccounts() {
        User user = Optional.ofNullable(ThreadLocalUser.getUser()).orElseThrow(() -> new HmException(USER_NOT_EXIST));
        return Lists.newArrayList();
    }

    @Override
    public AssetsAccount getAccountById(String id) {
        return null;
    }

    @Override
    public AccountListVO getAccountList() {

        List<LiabilityAccount> liabilityAccounts = liabilityAccountService.getAccounts();
        List<AssetsAccount> assetsAccounts = getAccounts();

        return assetsAccountTransfer.buildAccountListVO(assetsAccounts, liabilityAccounts);
    }
}
