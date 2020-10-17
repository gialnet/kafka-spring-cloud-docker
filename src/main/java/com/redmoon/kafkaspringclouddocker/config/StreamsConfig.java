package com.redmoon.kafkaspringclouddocker.config;

import com.redmoon.kafkaspringclouddocker.topics.MessageStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(MessageStream.class)
public class StreamsConfig {
}
