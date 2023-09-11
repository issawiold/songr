package com.example.songr.repositores;

import com.example.songr.controller.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {
    long findById(long id);

}
