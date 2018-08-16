package com.hamster.ak.transfer;

import com.hamster.ak.api.LiabilityAccount;
import com.hamster.ak.api.LiabilityAccountCreation;
import com.hamster.ak.api.LiabilityAccountUpdateForm;
import com.hamster.ak.api.User;
import com.hamster.ak.bean.LiabilityAccountBean;
import com.hamster.ak.common.bean.ThreadLocalUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LiabilityAccountTransfer {

    public LiabilityAccountBean transferTOLiabilityAccountBean(LiabilityAccountCreation creation) {
        User user = ThreadLocalUser.getUser();
        LiabilityAccountBean.LiabilityAccountBeanBuilder builder = LiabilityAccountBean.builder();
        creation.getDescription().ifPresent(builder::description);
        return builder.name(creation.getName())
                .type(creation.getType())
                .userId(user.getId())
                .lineOfCredit(creation.getLineOfCredit())
                .statementDate(creation.getStatementDate())
                .repaymentDate(creation.getRepaymentDate())
                .creator(user.getName())
                .modifier(user.getName())
                .build();
    }


    public LiabilityAccountBean transferTOLiabilityAccountBean(Integer accountId, LiabilityAccountUpdateForm account) {
        LiabilityAccountBean.LiabilityAccountBeanBuilder builder = LiabilityAccountBean.builder();

        account.getNewName().ifPresent(builder::name);
        account.getLineOfCredit().ifPresent(builder::lineOfCredit);
        account.getStatementDate().ifPresent(builder::statementDate);
        account.getRepaymentDate().ifPresent(builder::repaymentDate);

        return builder.id(accountId).modifier(ThreadLocalUser.getUser().getName()).build();
    }


    // FIXME @yanwenbo 使用copy 的方式将来可能会有问题
    public LiabilityAccount transferToLiabilityAccount(LiabilityAccountBean bean) {
        LiabilityAccount account = new LiabilityAccount();
        BeanUtils.copyProperties(bean, account);
        return account;
    }

    public List<LiabilityAccount> transferToLiabilityLists(List<LiabilityAccountBean> beans) {
        return beans.stream().map(bean ->
                LiabilityAccount.builder()
                        .id(bean.getId())
                        .name(bean.getName())
                        .userId(bean.getUserId())
                        .type(bean.getType())
                        .lineOfCredit(bean.getLineOfCredit())
                        .statementDate(bean.getStatementDate())
                        .repaymentDate(bean.getRepaymentDate())
                        .created(bean.getCreated())
                        .creator(bean.getCreator())
                        .modified(bean.getModified())
                        .modifier(bean.getModifier())
                        .build()
        ).collect(Collectors.toList());

    }
}