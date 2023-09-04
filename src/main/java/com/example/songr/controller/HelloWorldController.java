package com.example.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@Controller
public class HelloWorldController {

    @GetMapping("/hello-world")
    @ResponseBody
    public String sayHello() {
        return "Hello world";
    }
    @ResponseBody
    @GetMapping("/capitalize/hello")
    public String sayHelloCapitalize(){
        return "HELLO WORLD";
    }




}
