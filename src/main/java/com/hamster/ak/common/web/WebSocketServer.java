package com.hamster.ak.common.web;

import com.hamster.ak.api.BasicAdviceMessage;
import com.hamster.ak.api.RemindersVO;
import com.hamster.ak.common.config.WebSocketConfig;
import com.hamster.ak.common.exception.HmException;
import com.hamster.ak.common.handler.JsonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonObject;
import javax.validation.constraints.NotNull;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArraySet;

import static com.hamster.ak.common.exception.HmError.TOKEN_NOT_EXIST;
import static com.hamster.ak.common.exception.HmError.USER_NOT_LOGIN;
import static com.hamster.ak.common.exception.HmError.WS_SEND_MESSAGE_ERROR;

@Slf4j
@ServerEndpoint(value = "/notify", configurator = WebSocketConfig.class, encoders = JsonEncoder.class)
@Component
public class WebSocketServer {

    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    /**
     * 建立连接调用
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {

        this.session = session;
        log.info("session: " + session);
        webSocketSet.add(this);
        addOnlineCount();
        log.info("有新的连接加入,session: [" + session.getId() + session.getRequestURI() + "], 在线设备： "
                + getOnlineCount());

        sendMessage("连接成功");
    }

    /**
     * 关闭连接调用
     */
    @OnClose
    public void onClose() {
        Optional.ofNullable(session).orElseThrow(() -> new HmException(USER_NOT_LOGIN));
            webSocketSet.remove(this);
            subOnlineCount();
            log.info("有连接关闭,session: [" + session.getId() + ", " + session.getRequestURI() + "], 在线设备： "
                    + getOnlineCount());
    }

    /**
     * 接收客户端消息调用【只接受不处理】
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("客户端 session: [" + session.getId() + ", " + session.getRequestURI() + "] 发来消息: " + message);

//        TODO @yanwenbo 消息群发，可用于用户组内，暂不支持
//        webSocketSet.forEach(item -> item.sendMessage(message));
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("websocket 产生错误");
        throwable.printStackTrace();
    }


    /**
     * 自定义消息推送，向制定用户推送消息
     *
     * @param message
     */
    public void sendAdvice(@NotNull BasicAdviceMessage message, @NotNull Integer userId) {

        webSocketSet.stream().filter(webSocketServer ->
                Optional.ofNullable(webSocketServer.session.getUserProperties().get("userId")).orElseThrow(() ->
                        new HmException(TOKEN_NOT_EXIST)).equals(userId))
                .forEach(socket -> socket.sendMessage(message));
    }

    /**
     * @param map
     */
    public void sendMessage(@NotNull Map<Integer, RemindersVO> map) {
        // FIXME @yanwenbo 最简单的操作 没有考虑失败重试/漏掉其他。
        // FIXME 遍历时先遍历需要发送的消息列表，对于没有建立连接的用户需要在数据库中存储（不清楚现在的app 强制推送时怎么做的，就需要存储，等待连接重试）
        // TODO 这里可以开多线程提高速度
        map.forEach((key, value) ->
                webSocketSet.stream().filter(socket -> socket.session.getUserProperties().get("userId").equals(key))
                        .forEach(socket -> socket.sendMessage(value)));
    }

    /**
     * @param message not null
     */
    public void sendMessage(@NotNull BasicAdviceMessage message) {
        try {
            this.session.getBasicRemote().sendObject(message);
        } catch (IOException | EncodeException e) {
            throw new HmException(WS_SEND_MESSAGE_ERROR);
        }
    }

    /**
     * 发送文本消息
     *
     * @param message not null
     */
    public void sendMessage(@NotNull String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            throw new HmException(WS_SEND_MESSAGE_ERROR);
        }
    }

    /**
     * 群发文本消息
     *
     * @param message
     */
    public void sendGroupTextMessage(@NotNull String message) {
        webSocketSet.forEach(socket -> socket.sendMessage(message));
    }

    /**
     * 群发非文本消息
     *
     * @param message
     */
    public void sendGroupMessage(@NotNull BasicAdviceMessage message) {
        webSocketSet.forEach(socket -> socket.sendMessage(message));
    }

    private void sendMessage(RemindersVO message) {
        try {
            JsonObject obj = Json.createObjectBuilder().add("message", message.toJson()).build();
            this.session.getBasicRemote().sendObject(obj);
        } catch (IOException | EncodeException e) {
            throw new HmException(WS_SEND_MESSAGE_ERROR);
        }
    }


    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
