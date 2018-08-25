package com.hamster.ak.common.handler;

import com.hamster.ak.common.enumeration.AccountPeriodEnum;
import com.hamster.ak.common.enumeration.AccountTypeEnum;
import com.hamster.ak.common.enumeration.CostTypeEnum;
import com.hamster.ak.common.enumeration.LiabilityAccountTypeEnum;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(value = {AccountTypeEnum.class, AccountPeriodEnum.class, CostTypeEnum.class, LiabilityAccountTypeEnum.class})
public class GenericTypeHandler<E extends Enum> extends BaseEnumTypeHandler {

    public GenericTypeHandler(Class<E> type) {
        super(type);
    }
}
