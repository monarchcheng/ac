package mc.ac.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

    @JmsListener(destination = "test2.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer2收到的报文为:"+text);
    }

}
