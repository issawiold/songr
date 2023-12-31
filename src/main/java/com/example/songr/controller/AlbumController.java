package com.example.songr.controller;

import com.example.songr.models.AlbumsTable;
import com.example.songr.repositores.AlbumTableRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.RedirectView;


import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {
    @GetMapping("/albums")
    public String albums(Model model){

        //        AlbumsTable album1=new AlbumsTable("song1","singer1",1,1000,"https://www.itprotoday.com/sites/itprotoday.com/files/styles/article_featured_retina/public/bad%20code%20practices.jpg");

//        model.addAttribute("title1",album.getTitle());
//        model.addAttribute("artist1",album.getArtist());
//        model.addAttribute("songNumber1",album.getSongCount()+" songs");
//        model.addAttribute("length1",album.getLength()/60+" minutes");
//        model.addAttribute("imgUrl1",album.getImageUrl());
//        model.addAttribute("title2",album2.getTitle());
//        model.addAttribute("artist2",album2.getArtist());
//        model.addAttribute("songNumber2",album2.getSongCount()+" songs");
//        model.addAttribute("length2",album2.getLength()/60+" minutes");
//        model.addAttribute("imgUrl2",album2.getImageUrl());
//        model.addAttribute("title3",album3.getTitle());
//        model.addAttribute("artist3",album3.getArtist());
//        model.addAttribute("songNumber3",album3.getSongCount()+" songs");
//        model.addAttribute("length3",album3.getLength()/60+" minutes");
//        model.addAttribute("imgUrl3",album3.getImageUrl());
        List<AlbumsTable> albumTableWare = albumTableRepository.findAll();
        AlbumsTable album2=new AlbumsTable("song2","singer2",3,3000,"https://www.economist.com/img/b/1190/670/90/sites/default/files/images/2015/09/blogs/economist-explains/code2.png");
        AlbumsTable album3=new AlbumsTable("song3","singer3",4,4000,"https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Programming_code.jpg/800px-Programming_code.jpg");
        AlbumsTable album=new AlbumsTable("song1","singer1",1,1000,"https://www.itprotoday.com/sites/itprotoday.com/files/styles/article_featured_retina/public/bad%20code%20practices.jpg");
        albumTableRepository.save(album);
        albumTableRepository.save(album2);
        albumTableRepository.save(album3);

        model.addAttribute("albumTables", albumTableWare);
        return "album.html";
    }
    private final AlbumTableRepository albumTableRepository;
    @Autowired
    public AlbumController(AlbumTableRepository albumTableRepository){
        this.albumTableRepository=albumTableRepository;
    }


    @PostMapping("/create-album")
    public RedirectView createAlbum(String title, String artist, int songCount, int length, String imageUrl)
    {
        AlbumsTable newAlbum = new AlbumsTable( title,  artist,  songCount,  length, imageUrl);
        albumTableRepository.save(newAlbum);

        return new RedirectView("/albums");
    }




}
