package com.hamster.ak.transfer;

import com.hamster.ak.api.*;
import com.hamster.ak.bean.LiabilityAccountBean;
import com.hamster.ak.common.bean.ThreadLocalUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
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

    public Map<Integer, RemindersVO> transferToRepaymentReminders(List<LiabilityAccountBean> repaymentList) {
        return repaymentList.stream().collect(Collectors.toMap(LiabilityAccountBean::getUserId, item ->
                RemindersVO.builder().accountId(item.getId())
                        .accountName(item.getName())
                        // TODO @yanwenbo 该字段不存储在实体中，通过统计账户月账单，统计出当月已使用金额
                        .amount(0)
                        .lineOfCredit(item.getLineOfCredit())
                        .repayment(true)
                        .build()));
    }

    public Map<Integer, RemindersVO> transferToStatementReminders(List<LiabilityAccountBean> statementList) {
        return statementList.stream().collect(Collectors.toMap(LiabilityAccountBean::getUserId, item ->
                RemindersVO.builder().accountId(item.getId())
                        .accountName(item.getName())
                        .amount(0)
                        .lineOfCredit(item.getLineOfCredit())
                        .statement(true)
                        .build()));
    }
}
