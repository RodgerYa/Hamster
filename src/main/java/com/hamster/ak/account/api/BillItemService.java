package com.hamster.ak.account.api;

import java.util.List;

/**
 * @author yanwenbo
 */
public interface BillItemService {
    /**
     * 记账 新增款项 / 自动更新资产/负债的功能由前端处理
     * @param creation
     * @return BillItemId not null
     */
    String create(BillItemCreation creation);

    /**
     * 更新款项
     * @param billItem not null
     */
    void update(BillItem billItem);

    /**
     * 删除款项
     * @param billItemId not null
     */
    void delete(String billItemId);

    /**
     * 根据条件获取 billItem
     * @param filter not null
     * @return billItems
     */
    List<BillItem> queryBillItem(BillItemFilter filter);

}
