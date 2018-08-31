package com.hamster.ak.common.config;

import com.hamster.ak.api.TokenService;
import com.hamster.ak.common.exception.HmException;
import com.hamster.ak.impl.TokenServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Optional;

import static com.hamster.ak.common.exception.HmError.TOKEN_NOT_EXIST;

@Configuration
@Slf4j
public class WebSocketConfig extends ServerEndpointConfig.Configurator{

    @Autowired
    private TokenService tokenService;

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        StandardSessionFacade ssf = (StandardSessionFacade) request.getHttpSession();
        log.info("检测到请求 URI：" + request.getRequestURI());

        Object tokenStr = ssf.getAttribute("token");
        if (tokenStr != null) {
            TokenServiceImpl tokenServiceImpl = new TokenServiceImpl();
            Integer userId = Optional.ofNullable(tokenServiceImpl.decodeToken((String) tokenStr)).orElseThrow(() ->
                    new HmException(TOKEN_NOT_EXIST)).getUserId();
            sec.getUserProperties().put("userId", userId);
        }

        super.modifyHandshake(sec, request, response);
    }

    /**
     * webSocket
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
