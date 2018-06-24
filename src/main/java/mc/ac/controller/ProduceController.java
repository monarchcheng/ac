package mc.ac.controller;

import mc.ac.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProduceController {

    private Producer producer;

    @Autowired
    public ProduceController(Producer producer) {
        this.producer = producer;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/send")
    public String produce(){
        int i =0;
        while (i <100) {
            producer.sendMessage("test1.queue.string", "message from web--"+i);
            i++;
        }
        return "success";
    }

}
