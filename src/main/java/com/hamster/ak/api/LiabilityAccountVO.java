package com.hamster.ak.api;

import com.hamster.ak.common.enumeration.LiabilityAccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LiabilityAccountVO {
    private Integer id;
    private String name;
    private LiabilityAccountTypeEnum type;
    private Integer amount;

    public LiabilityAccountVO(LiabilityAccount account) {
        this.id = account.getId();
        this.name = account.getName();
        this.type = account.getType();
        this.amount = account.getAmount();
    }
}
