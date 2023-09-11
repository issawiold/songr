package com.example.songr.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Album {
    private String title;
    private String artist;
    private Integer songCount;
    private Integer length;
    private String imageUrl;

    public Album(String title, String artist, Integer songCount, Integer length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
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
}
