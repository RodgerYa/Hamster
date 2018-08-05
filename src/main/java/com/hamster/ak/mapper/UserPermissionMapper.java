package com.hamster.ak.mapper;

import com.hamster.ak.bean.UserPermissionBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserPermissionMapper {

    void insert(@Param("bean")UserPermissionBean bean);

    void deleteById(@Param("id") Integer userId);

    List<UserPermissionBean> selectById(@Param("id") Integer userId);
}
