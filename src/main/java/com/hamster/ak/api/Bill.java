package com.hamster.ak.api;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yanwenbo
 */
@Data
@Builder
public class Bill {
    private String id;
    private BigDecimal expenditure;
    private BigDecimal income;
    private List<BillItem> billItemList;

}
