package com.hamster.ak.mapper;

import com.hamster.ak.api.UserFilter;
import com.hamster.ak.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface UserMapper {
    UserBean selectByLoginName(@Param("loginName") String loginName);

    UserBean selectById(@Param("userId") Integer userId);

    int insert(@Param("bean") UserBean bean);

    /**
     * 更新密码
     */
    int updatePassword(@Param("userId") Integer userId, @Param("password") String password,
                       @Param("oper") String oper, @Param("modified") Date modified);

    /**
     * 更新密码外的其他字段
     */
    int update(@Param("bean") UserBean bean);

    int deleteByUserId(@Param("userId") Integer userId);

    long count(@Param("filter") UserFilter filter);

    List<UserBean> query(@Param("filter") UserFilter filter, @Param("offset") int offset,
                         @Param("limit") int limit, @Param("sortKey") String sortKey, @Param("desc") boolean desc);
}
