package com.springboot.basics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ThymeController {

    @RequestMapping("/thymee")
    public String thymee(Model model) {
        model.addAttribute("welcome", "Hola Thymee");
        model.addAttribute("name", "Jitu");
        model.addAttribute("last", "Thakur");
        model.addAttribute("date", new Date().toLocaleString());

//        Create Iterable
        List<String> me = List.of("Jeetu", "Jitu", "Jitesh", "Jeetesh");

        model.addAttribute("me", me);
        return "thymee";
    }
}
