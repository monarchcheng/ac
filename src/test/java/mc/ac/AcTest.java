package mc.ac;

import mc.ac.service.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcTest {

    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() throws InterruptedException {
        for(int i=0; i<100; i++){
            Map map = new HashMap();
            map.put("queueName","consume1 message--"+i);
            producer.sendMessage("test1.queue", map);
//            producer.sendMessage("test2.queue", "consume2 message--"+i);
        }
    }


}