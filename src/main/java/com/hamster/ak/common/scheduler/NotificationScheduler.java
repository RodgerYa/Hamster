package com.hamster.ak.common.scheduler;

import com.hamster.ak.api.LiabilityAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationScheduler {

    @Autowired
    private LiabilityAccountService liabilityAccountService;

    /**
     * 每天上午十点检查
     */
    @Scheduled(cron = "0 0 10 * * *")
    public void liabilityNotify() {
        liabilityAccountService.remind();
    }
}
