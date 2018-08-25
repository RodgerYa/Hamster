package com.hamster.ak.mapper;

import com.hamster.ak.bean.LiabilityAccountBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LiabilityAccountMapper {

    public List<LiabilityAccountBean> selectAll();

    public LiabilityAccountBean selectById(@Param("id") Integer id);

    public LiabilityAccountBean selectByUserIdAndName(@Param("userId") Integer userId, @Param("name") String name);

    public Integer update(@Param("bean") LiabilityAccountBean bean);

    public void delete(@Param("id") Integer id);

    public Integer insert(@Param("bean") LiabilityAccountBean bean);

    // FIXME @yanwenbo 目前查询出来的是日期严格一致，还需要处理特殊日期 28 29 30 31 出账期/还款期为月末的情况 但是每个月的月末不是固定
    public List<LiabilityAccountBean> selectRepaymentList();

    public List<LiabilityAccountBean> selectStatementList();
}
