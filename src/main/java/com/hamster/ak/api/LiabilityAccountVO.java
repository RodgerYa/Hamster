package com.hamster.ak.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class LiabilityAccountVO {
    private Integer id;
    private String name;
    private Integer amount;

    public LiabilityAccountVO(LiabilityAccount account) {
        this.id = account.getId();
        this.name = account.getName();
        this.amount = account.getAmount();
    }
}
