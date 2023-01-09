package com.evaluation.songlist.repository;

import com.evaluation.songlist.model.song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<song,String> {
}
