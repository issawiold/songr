package com.example.songr.controller;

import com.example.songr.models.AlbumsTable;

import javax.persistence.*;


@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer length;
    private Integer trackNumber;
    @ManyToOne
    private AlbumsTable album;

    public Song(Long id, String title, Integer length, Integer trackNumber, AlbumsTable album) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public Song(String title, Integer length, Integer trackNumber, AlbumsTable album) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public Song() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongTitle() {
        return title;
    }

    public void setSongTitle(String title) {
        this.title = title;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public AlbumsTable getAlbum() {
        return album;
    }

    public void setAlbum(AlbumsTable album) {
        this.album = album;
    }
}
