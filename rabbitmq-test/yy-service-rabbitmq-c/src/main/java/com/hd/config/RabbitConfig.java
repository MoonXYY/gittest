package com.hd.config;


import org.springframework.amqp.core.*;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitConfig
 * @Description TODO
 * @Author XyWorkPC
 * @Date 2019/6/28 10:28
 * @Version 1.0
 **/
@Configuration
public class RabbitConfig {

    //声明队列及交换机名
    public static final String QUEUE_SMS="queue_sms";
    public static final String QUEUE_EMAIL="queue_email";
    public static final String EXCHANGE_TOPICS_INFORM="exchange_topics_inform";


    /**
    * @Description 交换机配置
    * @param
    * @Return org.springframework.amqp.core.Exchange
    * @Author xiangyue
    * @Date 2019/6/28 10:37
    **/
    @Bean(EXCHANGE_TOPICS_INFORM)
    public Exchange EXCHANGE_TOPICS_INFORM(){
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS_INFORM).durable(true).build();
    }

    //声明队列
    @Bean(QUEUE_SMS)
    public Queue QUEUE_SMS(){
        return new Queue(QUEUE_SMS);
    }

    @Bean(QUEUE_EMAIL)
    public Queue QUEUE_EMAIL(){
        return new Queue(QUEUE_EMAIL);
    }

    @Bean
    public Binding BINDING_QUEUE_SMS(@Qualifier(QUEUE_SMS) Queue queue,@Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("inform.*.sms.#").noargs();
    }
    @Bean
    public Binding BINDING_QUEUE_EMAIL(@Qualifier(QUEUE_EMAIL) Queue queue,@Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("inform.*.email.#").noargs();
    }
}
