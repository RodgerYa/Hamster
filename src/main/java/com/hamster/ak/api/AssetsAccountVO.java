package com.hamster.ak.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class AssetsAccountVO {
    private Integer id;
    private String name;
    private Integer balance;

    public AssetsAccountVO(AssetsAccount assetsAccount) {
        this.id = assetsAccount.getId();
        this.name = assetsAccount.getName();
        this.balance = assetsAccount.getBalance();
    }
}
