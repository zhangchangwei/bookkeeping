package com.breamer.cloud.product.client.socketserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @date 2019/3/13 15:49
 */
@Component
@Slf4j
@ServerEndpoint("/websocket")
public class WebSocketServer {

    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<WebSocketServer> webSocketServers = new CopyOnWriteArraySet<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketServers.add(this);
        addOnlineCount();
        log.info("新窗口监听开启 -- 当前人数: {}", getOnlineCount());

    }

    @OnClose
    public void onClose(){
        webSocketServers.remove(this);
        subOnlineCount();
        log.info("窗口监听关闭 -- 当前人数: {}", getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session){
        webSocketServers.forEach(item -> item.sendMessage(message));
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    private void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendInfo(String message){
        webSocketServers.forEach(item -> item.sendMessage(message));
    }


    private static synchronized int getOnlineCount(){
        return onlineCount;
    }

    private static synchronized void addOnlineCount(){
        WebSocketServer.onlineCount++;
    }
    private static synchronized void subOnlineCount(){
        WebSocketServer.onlineCount--;
    }
}
