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
     * @param form not null
     */
    Integer update(LiabilityAccountUpdateForm form);

    /**
     * 删除账户
     *
     * @param accountId not null
     */
    void delete(Integer accountId);

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

    /**
     * 出账日/还款日 提醒
     */
    void remind();
}
