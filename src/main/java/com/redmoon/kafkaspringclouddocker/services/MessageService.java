package com.redmoon.kafkaspringclouddocker.services;

import com.redmoon.kafkaspringclouddocker.model.MessageBody;
import com.redmoon.kafkaspringclouddocker.topics.MessageStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class MessageService {

    private final MessageStream messageStream;

    public MessageService(MessageStream messageStream) {
        this.messageStream = messageStream;
    }

    public void SendMessage(MessageBody messageBody){

        log.info("Sending message {}", messageBody);

        MessageChannel messageChannel = messageStream.outboundMessage();

        messageChannel.send(MessageBuilder.
                                withPayload(messageBody).
                                setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE).
                                build());

    }
}
