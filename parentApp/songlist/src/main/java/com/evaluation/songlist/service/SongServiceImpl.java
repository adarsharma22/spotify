package com.evaluation.songlist.service;

import com.evaluation.songlist.model.song;
import com.evaluation.songlist.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServiceImpl implements SongService{
    @Autowired
    private SongRepository songRepository;
    @Override
    public List<song> getAllSongs() {
        return songRepository.findAll();
    }
}
