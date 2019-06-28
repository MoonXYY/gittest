package com.hd.service;

import com.hd.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName producer
 * @Description TODO
 * @Author XyWorkPC
 * @Date 2019/6/28 10:43
 * @Version 1.0
 **/

@Service
public class producer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void test(){
        for (int i = 0; i < 5; i++) {
            String message = "sms test"+i;
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPICS_INFORM,"inform.sms",message);
        }
    }

}
