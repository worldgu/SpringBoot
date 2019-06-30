package com.zero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import static com.zero.utils.WebSocketUtils.ONLINE_USER_SESSIONS;
import static com.zero.utils.WebSocketUtils.sendMessageAll;
/**
 * @author ：Zero
 * @date ：Created in 2019/6/30 21:33
 * @modified By：
 */
@RestController
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(ChatRoomServerEndpoint.class);

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        ONLINE_USER_SESSIONS.put(username, session);
        String message = "欢迎用户[" + username +"] 来到聊天室！";
        logger.info("用户登陆: " + message);
        sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        logger.info("发送消息: " + message);
        sendMessageAll("用户 [" + username + "] :" + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        //  当前的Session 移除
        ONLINE_USER_SESSIONS.remove(username);
        //  并且通知其他人当前用户已经离开聊天室
        sendMessageAll("用户[" + username + "] 已经离开聊天室了！");
        try {
            session.close();
        } catch (IOException e) {
            logger.error("onClose error", e);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            logger.error("onError excepiton",e);
        }
        logger.info("Throwable msg "+throwable.getMessage());
    }
}
