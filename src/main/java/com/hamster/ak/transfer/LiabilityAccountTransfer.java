package com.hamster.ak.transfer;

import com.hamster.ak.api.LiabilityAccount;
import com.hamster.ak.api.LiabilityAccountCreation;
import com.hamster.ak.api.User;
import com.hamster.ak.bean.LiabilityAccountBean;
import com.hamster.ak.common.bean.ThreadLocalUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LiabilityAccountTransfer {

    public LiabilityAccountBean transferTOLiabilityAccountBean(LiabilityAccountCreation creation) {
        User user = ThreadLocalUser.getUser();
        LiabilityAccountBean.LiabilityAccountBeanBuilder builder = LiabilityAccountBean.builder();
//        creation.getDescription().ifPresent(builder::description);
        return builder.name(creation.getName())
                .type(creation.getType())
                .userId(user.getId())
                .lineOfCredit(creation.getLineOfCredit())
                .statementDate(creation.getStatementDate())
                .repaymentDate(creation.getRepaymentDate())
                .creator(user.getName())
                .modifier(user.getName())
                .description(creation.getDescription())
                .build();
    }

    public LiabilityAccount transferTOLiabilityAccount(LiabilityAccountBean bean) {
        LiabilityAccount account = new LiabilityAccount();
        BeanUtils.copyProperties(bean, account);
        return account;
    }
}
