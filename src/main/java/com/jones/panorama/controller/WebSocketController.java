package com.jones.panorama.controller;

import com.jones.panorama.model.SocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by jones on 18-1-16.
 */
@Controller
@RequestMapping( "/ws" )
public class WebSocketController extends BaseController{
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendLocation")
    @SendTo("/client/getLocation")
    public SocketMessage send(SocketMessage message) throws Exception {
        message.setDate(df.format(new Date()));
        return message;
    }

    @Scheduled(fixedRate = 1000)
    @SendTo("/client/callback")
    public Object callback() throws Exception {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messagingTemplate.convertAndSend("/client/callback", df.format(new Date()));
        return "callback";
    }


}
