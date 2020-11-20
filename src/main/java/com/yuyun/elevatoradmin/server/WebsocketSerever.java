package com.yuyun.elevatoradmin.server;

import com.alibaba.fastjson.JSON;
import com.yuyun.elevatoradmin.entity.ElevatorEntity;
import com.yuyun.elevatoradmin.service.ElevatorService;
import com.yuyun.elevatoradmin.vo.ElevatorInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/websock/test")
@Component
public class WebsocketSerever {

    //引入自己的接口类，注意要加上static 静态修饰
    private static ElevatorService elevatorService;

    //mobileUserService的set方法
    @Autowired
    public  void setApplicationContext(ElevatorService elevatorService) {
       this.elevatorService=elevatorService;
    }
    @Autowired

//    private static final Logger log=new Logger();
    /**
     * 存放所有在线的客户端
     */
    private static Map<String, Session> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) {
//            log.info("有新的客户端连接了: {}", session.getId());
        //将新用户存入在线的组
        clients.put(session.getId(), session);
//        List<ElevatorEntity> elevators = elevatorService.getElevators();
////        for (ElevatorEntity e:elevators) {
////
////        }
//        String s = JSON.toJSONString(elevators);
//        session.getAsyncRemote().sendText(s);
    }

    /**
     * 客户端关闭
     *
     * @param session session
     */
    @OnClose
    public void onClose(Session session) {
//            log.info("有用户断开了, id为:{}", session.getId());
        //将掉线的用户移除在线的组里
        clients.remove(session.getId());
    }

    /**
     * 发生错误
     *
     * @param throwable e
     */
    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * 收到客户端发来消息
     *
     * @param message 消息对象
     */
    @OnMessage
    public void onMessage(String message) {
//            log.info("服务端收到客户端发来的消息: {}", message);
       elevatorService.getElevatorChange(message);
        String s = JSON.toJSONString(elevatorService);
        this.sendAll(s);

    }

    /**
     * 群发消息
     *
     * @param message 消息内容
     */
    private void sendAll(String message) {

        for (Map.Entry<String, Session> sessionEntry : clients.entrySet()) {
            sessionEntry.getValue().getAsyncRemote().sendText(message);
        }

    }
}
