package com.hamster.ak.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccountListVO {
    private Integer totalAssets;

    private Integer totalLiability;

    private List<AssetsAccountVO> assertsAccounts;

    private List<LiabilityAccountVO> liabilityAccounts;
}
