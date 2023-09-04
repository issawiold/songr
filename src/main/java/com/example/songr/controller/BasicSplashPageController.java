package com.example.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicSplashPageController {
    @GetMapping("/")
    public String basicSplashPage(Model model){
        String welcoming1="Welcome to our page     ";
        String welcoming2="to access hello world use route /hello";
        String welcoming3="to access hello world but capitalize use route /capitalize/hello";
        String welcoming4="you're Welcome";
        model.addAttribute("welcome1",welcoming1);
        model.addAttribute("welcome2",welcoming2);
        model.addAttribute("welcome3",welcoming3);
        model.addAttribute("welcome4",welcoming4);

        return "index.html";
    }
}
