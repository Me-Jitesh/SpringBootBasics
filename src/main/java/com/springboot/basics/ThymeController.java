package com.springboot.basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeController {

    @RequestMapping("/thymee")
    @ResponseBody
    public String thymee(){

        System.out.println("Me Thymee");
        return "me-thymee";
    }
}
