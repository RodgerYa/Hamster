package com.hamster.ak.transfer;

import com.hamster.ak.api.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssetsAccountTransfer {

    public AccountListVO buildAccountListVO(List<AssetsAccount> assetsAccounts,
                                            List<LiabilityAccount> liabilityAccounts) {
        return AccountListVO.builder()
                .assetsAccounts(assetsAccounts.stream().map(AssetsAccountVO::new).collect(Collectors.toList()))
                .liabilityAccounts(liabilityAccounts.stream().map(LiabilityAccountVO::new).collect(Collectors.toList()))
                .totalAssets(assetsAccounts.stream().mapToInt(AssetsAccount::getBalance).sum())
                .totalLiability(liabilityAccounts.stream().mapToInt(LiabilityAccount::getAmount).sum())
                .build();
    }
}
