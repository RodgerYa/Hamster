package com.hamster.ak.user.mapper;

import com.hamster.ak.user.bean.PermissionBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {

    void insert(@Param("bean") PermissionBean bean);

    void delete(@Param("id") Integer id);

    PermissionBean select(@Param("id") Integer id);

    List<PermissionBean> selectAll();

}
