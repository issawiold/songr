package com.example.songr.models;
import com.example.songr.controller.Album;
import com.example.songr.controller.Song;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AlbumsTable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private Integer songCount;
    private Integer length;
    private String imageUrl;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Song> songs;

    public AlbumsTable(String title, String artist, Integer songCount, Integer length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
        this.songs=new ArrayList<>();
    }
    public AlbumsTable(){

    }

    public AlbumsTable(Long id, String title, String artist, Integer songCount, Integer length, String imageUrl) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
        this.songs=new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getSongCount() {
        return songCount;
    }

    public Integer getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", songCount=" + songCount +
                ", length=" + length +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs.addAll(songs);
    }
}
