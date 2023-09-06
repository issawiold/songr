package com.example.songr.repositores;

import com.example.songr.models.AlbumsTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumTableRepository extends JpaRepository<AlbumsTable,Long>{
    String findByTitle(String title);
}
