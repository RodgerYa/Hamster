package com.hamster.ak.impl;

import com.hamster.ak.api.LiabilityAccount;
import com.hamster.ak.api.LiabilityAccountCreation;
import com.hamster.ak.api.LiabilityAccountService;
import com.hamster.ak.api.LiabilityAccountUpdateForm;
import com.hamster.ak.common.bean.ThreadLocalUser;
import com.hamster.ak.common.config.HamsterTx;
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
    @HamsterTx
    public Integer create(LiabilityAccountCreation creation) {

        Optional.ofNullable(liabilityAccountMapper.selectByUserIdAndName(ThreadLocalUser.getUser().getId(),
                creation.getName())).orElseThrow(() -> new HmException("当前负债账户已存在"));

        return Optional.ofNullable(liabilityAccountMapper.insert(liabilityAccountTransfer
                .transferTOLiabilityAccountBean(creation))).orElseThrow(() -> new HmException("新增负债账户失败"));
    }

    @Override
    @HamsterTx
    public Integer update(LiabilityAccountUpdateForm account) {

        Integer accountId = Optional.ofNullable(
                liabilityAccountMapper.selectByUserIdAndName(ThreadLocalUser.getUser().getId(), account.getOldName())
        ).orElseThrow(() -> new HmException("负债账户[" + account.getOldName() + "]不存在")).getId();

        return Optional.ofNullable(liabilityAccountMapper.update(liabilityAccountTransfer
                .transferTOLiabilityAccountBean(accountId, account))).orElseThrow(() ->
                new HmException("更新负债账户[" + account.getOldName() + "]失败"));
    }

    @Override
    @HamsterTx
    public void delete(Integer accountId) {
        Optional.ofNullable(liabilityAccountMapper.selectById(accountId)).orElseThrow(() ->
                new HmException("负债账户[id: " + accountId + "]不存在"));
        try {
            liabilityAccountMapper.delete(accountId);
        } catch (Exception e) {
            throw new HmException("删除账户[id:" + accountId + "]失败");
        }

    }

    @Override
    public List<LiabilityAccount> getAccounts() {
        return liabilityAccountTransfer.transferToLiabilityLists(
                Optional.ofNullable(liabilityAccountMapper.selectAll()).orElseThrow(() ->
                        new HmException("负债账户列表查询失败")));
    }

    @Override
    public LiabilityAccount getAccountById(Integer id) {

        return liabilityAccountTransfer.transferToLiabilityAccount(
                Optional.ofNullable(liabilityAccountMapper.selectById(id)).orElseThrow(() ->
                        new HmException("当前负债账户不存在")));
    }
}
