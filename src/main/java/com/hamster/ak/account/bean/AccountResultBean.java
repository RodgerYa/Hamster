package com.hamster.ak.account.bean;

import com.hamster.ak.account.api.AssetsAccount;
import com.hamster.ak.account.api.LiabilityAccount;
import lombok.Data;

import java.util.List;
import java.util.Optional;

/**
 * @author yanwenbo
 */
@Data
public class AccountResultBean {

    private Optional<List<AssetsAccount>> assetsAccounts;
    private Optional<List<LiabilityAccount>> liabilityAccounts;
}
