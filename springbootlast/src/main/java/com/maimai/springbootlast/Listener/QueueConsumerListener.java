package com.maimai.springbootlast.Listener;

import com.alibaba.fastjson.JSON;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-15 17:41
 **/
@Component
public class QueueConsumerListener
{
    //queue模式的消费者
    @JmsListener(destination="${spring.activemq.queue-name}", containerFactory="queueListener")
    public void readActiveQueue(Object message) throws JMSException {
//        System.out.println("queue接受到：" + message);
//        ObjectMessage activeMQObjectMessage= (ObjectMessage) message;
//        System.out.println("queue接受到2：" + JSON.toJSONString(activeMQObjectMessage.getObject()));
        if (message instanceof ActiveMQTextMessage) {
            ActiveMQTextMessage activeMQTextMessage = (ActiveMQTextMessage) message;
            System.out.println("queue接受到字符串：" + activeMQTextMessage.getText());
        }
        if (message instanceof ActiveMQObjectMessage) {
            System.out.println("queue接受到实体：" + message);
            ObjectMessage activeMQObjectMessage = (ObjectMessage) message;
            System.out.println("queue接受到实体2：" + JSON.toJSONString(activeMQObjectMessage.getObject()));
        }


    }
}
