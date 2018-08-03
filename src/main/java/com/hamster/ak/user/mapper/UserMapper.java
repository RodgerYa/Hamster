package com.hamster.ak.user.mapper;

import com.hamster.ak.user.api.UserFilter;
import com.hamster.ak.user.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface UserMapper {
    public UserBean selectByLoginName(@Param("loginNameLike") String loginName);

    public UserBean selectById(@Param("userId") Integer userId);

    public int insert(@Param("bean") UserBean bean);

    public int updatePassword(@Param("userId") Integer userId, @Param("password") String password,
                              @Param("oper") String oper, @Param("modified") Date modified);

    public int deleteByUserId(@Param("userId") Integer userId);

    public long count(@Param("filter") UserFilter filter);

    public List<UserBean> query(@Param("filter") UserFilter filter, @Param("offset") int offset,
                                @Param("limit") int limit, @Param("sortKey") String sortKey, @Param("desc") boolean desc);
}
