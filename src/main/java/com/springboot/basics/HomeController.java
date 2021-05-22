package com.springboot.basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showHome() {
        return "home";
    }

    @RequestMapping("/devTools")
    @ResponseBody
    public String testDevTool() {
        int a = 10;
        int b = 20;
        int d = 20;
        int e = 20;
        return "Hola Bachcho " + (a + b + d + e);
    }
}
