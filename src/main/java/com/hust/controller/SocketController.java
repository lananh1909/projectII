package com.hust.controller;

import com.hust.model.Notification;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocketController {
    @MessageMapping("/user")
    @SendTo("/topic/user")
    public Notification send(@Payload Notification message){
        return message;
    }
}
