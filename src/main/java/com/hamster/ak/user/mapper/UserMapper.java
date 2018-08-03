package com.hamster.ak.user.mapper;

import com.hamster.ak.user.api.UserFilter;
import com.hamster.ak.user.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface UserMapper {
    UserBean selectByLoginName(@Param("loginNameLike") String loginName);

    UserBean selectById(@Param("userId") Integer userId);

    int insert(@Param("bean") UserBean bean);

    int updatePassword(@Param("userId") Integer userId, @Param("password") String password,
                              @Param("oper") String oper, @Param("modified") Date modified);

    int deleteByUserId(@Param("userId") Integer userId);

    long count(@Param("filter") UserFilter filter);

    List<UserBean> query(@Param("filter") UserFilter filter, @Param("offset") int offset,
                                @Param("limit") int limit, @Param("sortKey") String sortKey, @Param("desc") boolean desc);
}
