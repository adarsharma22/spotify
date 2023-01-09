package com.evaluation.songlist.controller;

import com.evaluation.songlist.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/song-app/v1")
@CrossOrigin("*")
public class SongController {
    @Autowired
    private SongService songService;

   // [GET]
    // http://localhost:1111/song-app/v1/get-all-songs
    @GetMapping("/get-all-songs")
    public ResponseEntity<?>getAllSongs(){
        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }
}
