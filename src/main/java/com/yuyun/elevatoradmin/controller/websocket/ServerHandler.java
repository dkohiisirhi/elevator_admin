package com.yuyun.elevatoradmin.controller.websocket;

import com.alibaba.fastjson.JSON;
import com.yuyun.elevatoradmin.service.ElevatorService;
import com.yuyun.elevatoradmin.vo.ElevatorChangeInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Controller
public class ServerHandler extends TextWebSocketHandler {


    //引入自己的接口类，注意要加上static 静态修饰
    private static ElevatorService elevatorService;



    @Autowired
    public void setElevatorDataService(ElevatorService elevatorService) {
        ServerHandler.elevatorService = elevatorService;
    }

    /**
     * 连接成功调用
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    }


    @Override
    public synchronized void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        //获取到连接对象的消息
        String msg = message.getPayload().toString();
        //获取，每个电梯运行数据
        ElevatorChangeInfoVo elevatorChange = elevatorService.getElevatorChange(msg);
        String data = JSON.toJSONString(elevatorChange);
        //发送数据
        session.sendMessage(new TextMessage(data));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }
}
