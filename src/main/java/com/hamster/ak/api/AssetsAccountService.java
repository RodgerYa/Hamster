package com.hamster.ak.api;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanwenbo
 */
@Service
public interface AssetsAccountService {

    /**
     * 新建资产账户
     *
     * @param creation not null
     *
     * @return 账户id
     */
    String create(AssetsAccountCreation creation);

    /**
     * 更新资产账户
     *
     * @param assetsAccount not null
     */
    void update(AssetsAccount assetsAccount);

    /**
     * 删除账户
     *
     * @param accountId not null
     */
    void delete(String accountId);

    /**
     * 获取全部账户
     * @return 账户列表
     */
    List<AssetsAccount> getAccounts();

    /**
     * 根据id 获取账户
     *
     * @param id not null
     *
     * @return 账户
     */
    AssetsAccount getAccountById(String id);

    /**
     * 获取账户列表
     * @return
     */
    AccountListVO getAccountList();
}
