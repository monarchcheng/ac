package mc.ac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProduceController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

}
