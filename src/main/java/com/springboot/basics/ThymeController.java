package com.springboot.basics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ThymeController {

    @RequestMapping("/thymee")
    public String thymee(Model model) {
        model.addAttribute("welcome", "Hola Thymee");
        model.addAttribute("name", "Jitu");
        model.addAttribute("last", "Thakur");
        model.addAttribute("date", new Date().toLocaleString());
        return "thymee";
    }
}
