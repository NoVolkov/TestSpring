package ru.volkov.SMVC.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/fc")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            Model model){
        model.addAttribute("message","Hello "+name);
        return "first/hello";
    }
    @GetMapping("/calc")
    public String calc(@RequestParam(value = "a", required = false) int a,
                       @RequestParam(value = "b", required = false) int b,
                       @RequestParam(value = "action", required = false) String action,
                       Model model){
        switch (action){
            case "addition": model.addAttribute("res",a+b);break;
            case "subtraction": model.addAttribute("res",a-b);break;
            case "multiplication": model.addAttribute("res",a*b);break;
            case "division": model.addAttribute("res",a/b);break;
        }
        return "first/calculator";
    }
    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}
