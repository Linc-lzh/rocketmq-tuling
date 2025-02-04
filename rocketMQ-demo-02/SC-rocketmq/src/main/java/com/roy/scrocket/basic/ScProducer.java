package com.roy.scrocket.basic;

import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：楼兰
 * @description:
 **/

@Component
public class ScProducer {

    @Resource
    private Source source;

    public void sendMessage(String msg){
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "testTag");
        MessageHeaders messageHeaders = new MessageHeaders(headers);
        Message<String> message = MessageBuilder.createMessage(msg, messageHeaders);
        this.source.output().send(message);

//        MessageBuilder<String> builder = MessageBuilder.withPayload(msg)
//                .setHeader(RocketMQHeaders.TAGS, "testTag")
//                .setHeader(RocketMQHeaders.KEYS, "myKey")
//                .setHeader("DELAY", "1");
//        Message<String> message = builder.build();
//        this.source.output().send(message);
    }
}

