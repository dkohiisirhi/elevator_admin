package com.yuyun.elevatoradmin.config;

import com.yuyun.elevatoradmin.controller.websocket.RunMileageHandler;
import com.yuyun.elevatoradmin.controller.websocket.ServerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    /**
     * websocket握手
     *
     * @param webSocketHandlerRegistry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(ServerController(), "/websock/test").addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins("*");
        webSocketHandlerRegistry.addHandler(RunMileageController(), "/websock/runMileage").addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins("*");
    }

    @Bean
    public TextWebSocketHandler ServerController() {
        return new ServerHandler();
    }

    @Bean
    public TextWebSocketHandler RunMileageController() {
        return new RunMileageHandler();
    }

}
