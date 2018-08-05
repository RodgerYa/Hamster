package com.hamster.ak.bean;

import com.hamster.ak.api.AssetsAccount;
import com.hamster.ak.api.LiabilityAccount;
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
