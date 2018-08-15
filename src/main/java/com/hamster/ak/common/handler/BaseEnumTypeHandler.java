package com.hamster.ak.common.handler;

import com.hamster.ak.common.enumeration.AccountPeriodEnum;
import com.hamster.ak.common.enumeration.AccountTypeEnum;
import com.hamster.ak.common.enumeration.CostTypeEnum;
import com.yan.jackson.EnumUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 枚举类型转换处理器
 */
public class BaseEnumTypeHandler<E extends Enum> extends BaseTypeHandler<E> {

    private Class<E> type;

    public BaseEnumTypeHandler() {}

    public BaseEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        } else {
            this.type = type;
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, (Integer) EnumUtil.getEnumProp(e, "code"));
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Integer code = resultSet.getInt(s);
        return EnumUtil.getEnum(type, "code", code).orElse(null);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Integer code = resultSet.getInt(i);
        return EnumUtil.getEnum(type, "code", code).orElse(null);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer code = callableStatement.getInt(i);
        return EnumUtil.getEnum(type, "code", code).orElse(null);
    }
}
