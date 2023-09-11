package com.example.songr.exceptions;

public class SongNotFoundException extends RuntimeException{
    public SongNotFoundException(String message) {
        super(message);
    }
    public SongNotFoundException(Throwable cause) {
        super(cause);
    }


}
