package com.jones.panorama.controller;

import com.jones.panorama.config.SocketSessionRegistry;
import com.jones.panorama.model.GeneralResponse;
import com.jones.panorama.model.SocketMessage;
import com.jones.panorama.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


/**
 * Created by jones on 18-1-16.
 */
@Controller
@RequestMapping( "/ws" )
public class WebSocketController extends BaseController{
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private SocketSessionRegistry webAgentSessionRegistry;

    @MessageMapping("/sendLocation")
    public SocketMessage send(SocketMessage message, @Header("code") String code,
                              @Headers Map<String, Object> headers) throws Exception {
        message.setDate(df.format(new Date()));
        webAgentSessionRegistry.getSessionIds(code).forEach(p->{
            template.convertAndSendToUser(p, "/client/getLocation", message, createHeaders(p));
        });
        return message;
    }

  /*  @Scheduled(fixedRate = 1000)
    @SendTo("/client/callback")
    public Object callback() throws Exception {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        template.convertAndSend("/client/callback", df.format(new Date()));
        return "callback";
    }*/

    @ResponseBody
    @RequestMapping(value = "/getCode", method = RequestMethod.GET)
    GeneralResponse getCode() {
        return new GeneralResponse(true, RandomString.generate(5));
    }


    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }


}
