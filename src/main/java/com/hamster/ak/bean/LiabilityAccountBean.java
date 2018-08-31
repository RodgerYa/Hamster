package com.hamster.ak.bean;

import com.hamster.ak.common.enumeration.LiabilityAccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiabilityAccountBean {

    private Integer id;

    private Integer userId;

    private String name;

    private LiabilityAccountTypeEnum type;

    private Integer lineOfCredit;

    private Integer totalCost;

    private Integer amount;

    private Integer statementDate;

    private Integer repaymentDate;

    private Date created;

    private String creator;

    private String modifier;

    private Date modified;

    private String description;

}
