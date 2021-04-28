package ru.volkov.SMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller")
public class HelloController {
    @GetMapping
    public String page(){
        return "page";
    }
    @GetMapping("/hello-world")
    public String sayHello(){
        return "hello_world";
    }
}
