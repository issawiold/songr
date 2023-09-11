package com.example.songr.repositores;

import com.example.songr.models.AlbumsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumTableRepository extends JpaRepository<AlbumsTable,Long>{
    long findById(long id);

}
