package com.hd.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.hd.config.RabbitConfig;


/**
 * @ClassName consumer
 * @Description TODO
 * @Author XyWorkPC
 * @Date 2019/6/28 10:49
 * @Version 1.0
 **/

@Service
public class consumer {


    //监听队列
    @RabbitListener(queues ={RabbitConfig.QUEUE_EMAIL})
    public void recive_email(String msg, Message message, Channel channel){
        System.out.println(msg);
    }
    //监听队列
    @RabbitListener(queues ={RabbitConfig.QUEUE_SMS})
    public void recive_sms(String msg, Message message, Channel channel){
        System.out.println(msg);
    }
}
