package com.hamster.ak.api;

import com.hamster.ak.common.enumeration.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AssetsAccountVO {
    private Integer id;
    private String name;
    private AccountTypeEnum type;
    private Integer balance;

    public AssetsAccountVO(AssetsAccount assetsAccount) {
        this.id = assetsAccount.getId();
        this.name = assetsAccount.getName();
        this.type = assetsAccount.getType();
        this.balance = assetsAccount.getBalance();
    }
}
