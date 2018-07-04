package com.hamster.ak.account.api;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yanwenbo
 */
@Data
public class Bill {
    private String id;
    private BigDecimal expenditure;
    private BigDecimal income;
    private List<BillItem> billItemList;

}
