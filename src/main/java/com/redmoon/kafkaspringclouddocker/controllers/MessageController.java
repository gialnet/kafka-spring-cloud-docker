package com.redmoon.kafkaspringclouddocker.controllers;

import com.redmoon.kafkaspringclouddocker.model.MessageBody;
import com.redmoon.kafkaspringclouddocker.services.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/new-message")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void ReadMessage(@RequestParam("message") String message){

        MessageBody messageBody = MessageBody.
                builder()
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();

        messageService.SendMessage(messageBody);
    }
}
