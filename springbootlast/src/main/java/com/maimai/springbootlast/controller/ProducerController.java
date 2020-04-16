package com.maimai.springbootlast.controller;

import com.maimai.springbootlast.entity.Gril;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Topic;
import java.io.Serializable;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-15 17:38
 **/
@RestController
public class ProducerController
{
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @PostMapping("/queue/test")
    public String sendQueue(@RequestBody String str) {
        this.sendMessage(this.queue, str);
        return "success";
    }

    @PostMapping("/topic/test")
    public String sendTopic(@RequestBody String str) {
        this.sendMessage(this.topic, str);
        return "success";
    }

    @PostMapping("/queue/gril")
    public String sendQueuegril(@RequestBody Gril gril) throws JMSException {

//        ActiveMQObjectMessage msg = new ActiveMQObjectMessage();
//        msg.setObject((Serializable) gril);


        this.sendMessage(this.queue, gril);
        return "success";
    }

    @PostMapping("/topic/gril")
    public String sendTopicgril(@RequestBody Gril gril) throws JMSException {

        this.sendMessage(this.topic, gril);
        return "success";
    }

    // 发送消息，destination是发送到的队列，message是待发送的消息
    private void sendMessage(Destination destination, final Object message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
