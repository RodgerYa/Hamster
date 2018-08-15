package com.hamster.ak.common.handler;

import com.hamster.ak.common.enumeration.AccountPeriodEnum;
import com.hamster.ak.common.enumeration.AccountTypeEnum;
import com.hamster.ak.common.enumeration.CostTypeEnum;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(value = {AccountTypeEnum.class, AccountPeriodEnum.class, CostTypeEnum.class})
public class GenericTypeHandler<E extends Enum> extends BaseEnumTypeHandler {

    public GenericTypeHandler(Class<E> type) {
        super(type);
    }
}
