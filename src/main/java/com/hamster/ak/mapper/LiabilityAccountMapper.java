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

    public int update(@Param("bean") LiabilityAccountBean bean);

    public void delete(@Param("id") Integer id);

    public Integer insert(@Param("bean") LiabilityAccountBean bean);
}
