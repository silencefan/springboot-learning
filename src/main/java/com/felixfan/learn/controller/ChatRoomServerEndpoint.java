package com.felixfan.learn.controller;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import static com.felixfan.learn.util.WebSocketUtils.LIVING_SESSIONS_CACHE;
import static com.felixfan.learn.util.WebSocketUtils.sendMessage;
import static com.felixfan.learn.util.WebSocketUtils.sendMessageAll;

/**
 * @author felix.fan
 * @date 2019/11/3 23:46
 */
@RestController
@ServerEndpoint("/chat-room/{username}")
@Slf4j
public class ChatRoomServerEndpoint {

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        LIVING_SESSIONS_CACHE.put(username, session);
        String message = "欢迎用户[" + username + "] 来到聊天室！";
        log.info(message);
        sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        log.info(message);
        sendMessageAll("用户[" + username + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        //当前的session移除
        LIVING_SESSIONS_CACHE.remove(username);
        //并且通知其他人当前用户已经离开聊天室了
        sendMessageAll("用户[" + username + "] 已经离开聊天室了！");
        try {
            session.close();
        } catch (IOException e) {
            log.error("onClose error. e = {}", Throwables.getStackTraceAsString(e));
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            log.error("onError error. e = {}", Throwables.getStackTraceAsString(e));
        }
        throwable.printStackTrace();
    }

    @GetMapping("/chat-room/{sender}/to/{receiver}")
    public void onMessage(@PathVariable("sender") String sender, @PathVariable("receiver") String receiver, String message) {
        sendMessage(LIVING_SESSIONS_CACHE.get(receiver), "[" + sender + "]" + "-> [" + receiver + "] : " + message);
    }
}