package mc.ac.service;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {

    @JmsListener(destination = "test1.queue.string")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
    }

    @JmsListener(destination = "test1.queue.map")
    @SendTo("back.queue")
    public String receiveQueue(ActiveMQMapMessage message) {
        try {
            Map map = message.getContentMap();
            return "【处理完毕:" + map.get("queueName")+"】";
        } catch (Exception e) {
           return null;
        }

    }
}
