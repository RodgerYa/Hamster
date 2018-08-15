package com.hamster.ak.api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LiabilityAccountService {

    /**
     * 新建负债账户
     *
     * @param creation not null
     *
     * @return 账户id
     */
    Integer create(LiabilityAccountCreation creation);

    /**
     * 更新负债账户
     *
     * @param account not null
     */
    void update(LiabilityAccount account);

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
    List<LiabilityAccount> getAccounts();

    /**
     * 根据id 获取账户
     *
     * @param id not null
     *
     * @return 账户
     */
    LiabilityAccount getAccountById(Integer id);
}
