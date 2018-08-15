package com.hamster.ak.bean;

import com.hamster.ak.common.enumeration.AccountTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

@Data
@Builder
public class LiabilityAccountBean {

    private Integer id;

    private Integer userId;

    private String name;

    private AccountTypeEnum type;

    private Integer lineOfCredit;

    private Integer statementDate;

    private Integer repaymentDate;

    private Date created;

    private String creator;

    private String modifier;

    private Date modified;

    private Optional<String> description;

}
