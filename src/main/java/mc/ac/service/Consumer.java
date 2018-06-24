package mc.ac.service;

import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQMapMessage;
import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.ObjectMessage;
import java.util.Map;

@Component
public class Consumer {

    @JmsListener(destination = "test1.queue.string")
    @SendTo("back.queue.string")
    public String receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
        return "【处理完毕:" + text+"】";
    }

    @JmsListener(destination = "test1.queue.map")
    @SendTo("back.queue.map")
    public String receiveQueue(Map map) {
        try {
            System.out.println(map.get("queueName"));
            return "【处理完毕:" + map.get("queueName")+"】";
        } catch (Exception e) {
            return null;
        }

    }

}
