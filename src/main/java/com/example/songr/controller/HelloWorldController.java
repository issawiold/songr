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
    @GetMapping("/")
    public String basicSplashPage(Model model){
        String welcomingM="Welcome to our page to access hello world use route /hello  to access hello world but capitalize use route /capitalize/hello  you're Welcome";
        model.addAttribute("welcome",welcomingM);
        return "index.html";
    }
    @GetMapping("/albums")
    public String albums(Model model){
        Album album2=new Album("song2","singer2",3,3000,"https://www.economist.com/img/b/1190/670/90/sites/default/files/images/2015/09/blogs/economist-explains/code2.png");
        Album album3=new Album("song3","singer3",4,4000,"https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Programming_code.jpg/800px-Programming_code.jpg");
        Album album=new Album("song1","singer1",1,1000,"https://www.itprotoday.com/sites/itprotoday.com/files/styles/article_featured_retina/public/bad%20code%20practices.jpg");
        model.addAttribute("title1",album.getTitle());
        model.addAttribute("artist1",album.getArtist());
        model.addAttribute("songNumber1",album.getSongCount()+" songs");
        model.addAttribute("length1",album.getLength()/60+" minutes");
        model.addAttribute("imgUrl1",album.getImageUrl());
        model.addAttribute("title2",album2.getTitle());
        model.addAttribute("artist2",album2.getArtist());
        model.addAttribute("songNumber2",album2.getSongCount()+" songs");
        model.addAttribute("length2",album2.getLength()/60+" minutes");
        model.addAttribute("imgUrl2",album2.getImageUrl());
        model.addAttribute("title3",album3.getTitle());
        model.addAttribute("artist3",album3.getArtist());
        model.addAttribute("songNumber3",album3.getSongCount()+" songs");
        model.addAttribute("length3",album3.getLength()/60+" minutes");
        model.addAttribute("imgUrl3",album3.getImageUrl());
        return "album.html";
    }



}
