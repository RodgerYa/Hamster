package com.hamster.ak.user.mapper;

import com.hamster.ak.user.bean.PermissionBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {

    public void insert(@Param("bean") PermissionBean bean);

    public void delete(@Param("id") Integer id);

    public PermissionBean select(@Param("id") Integer id);

    public List<PermissionBean> selectAll();

}
