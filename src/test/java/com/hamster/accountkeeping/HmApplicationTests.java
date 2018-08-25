package com.hamster.accountkeeping;

import com.hamster.ak.api.LiabilityAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.client.WebSocketClient;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HmApplicationTests {

    @Autowired
    private LiabilityAccountService liabilityAccountService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void remindTest() {
        liabilityAccountService.remind();
    }

}
