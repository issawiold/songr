package com.example.songr.controller;

import com.example.songr.models.AlbumsTable;
import com.example.songr.repositores.AlbumTableRepository;
import com.example.songr.repositores.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.songr.controller.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller
public class SongController {
    @Autowired
    private final AlbumTableRepository albumTableRepository;
    @Autowired
    private final SongRepository songRepository;

    @Autowired
    public SongController(AlbumTableRepository albumTableRepository, SongRepository songRepository) {
        this.albumTableRepository = albumTableRepository;
        this.songRepository = songRepository;
    }

    @GetMapping("/songs/{id}")
    public String albums(@PathVariable Integer id, Model model) {
        List<com.example.songr.controller.Song> songRepo = songRepository.findAll();
        model.addAttribute("Songs", songRepo);
        return "song.html";
    }

    @PostMapping("/add-song")
    public RedirectView createSong(String title, Integer length, Integer trackNumber, AlbumsTable album) {
        com.example.songr.controller.Song newSong = new com.example.songr.controller.Song(title, length, trackNumber, album);
        songRepository.save(newSong);
        return new RedirectView("/songs/" + album.getId());
    }
}
