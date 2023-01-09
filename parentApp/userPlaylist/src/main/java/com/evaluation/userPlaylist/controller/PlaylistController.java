package com.evaluation.userPlaylist.controller;

import com.evaluation.userPlaylist.model.Song;
import com.evaluation.userPlaylist.model.UserPlaylist;
import com.evaluation.userPlaylist.service.UserPlaylistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlist-app/v1")
public class PlaylistController {
    @Autowired
    private UserPlaylistServiceImpl userPlaylistServiceImpl;

    //[POST]
    //http://localhost:3333/playlist-app/v1/add-user
    @PostMapping("/add-user")
    public ResponseEntity<?>addUser(@RequestBody UserPlaylist userPlaylist){
        return new ResponseEntity<>(userPlaylistServiceImpl.addUser(userPlaylist), HttpStatus.OK);
    }

    //[POST]
    //http://localhost:3333/playlist-app/v1/add-song-to-playlist/adadarsh22@gmail.com
    @PostMapping("/add-song-to-playlist/{emailId}")
    public ResponseEntity<?>addSongToUserPlaylist(@PathVariable String emailId,@RequestBody Song song){
        return new ResponseEntity<>(userPlaylistServiceImpl.addSongToUserPlaylist(emailId,song),HttpStatus.OK);
    }

    //[DELETE]
    //http://localhost:3333/playlist-app/v1/delete-song/adadarsh22@gmail.com/S001
    @DeleteMapping("/delete-song/{emailId}/{songId}")
    public ResponseEntity<?>deleteSongFromUserPlaylist(@PathVariable String emailId,@PathVariable String songId){
        return new ResponseEntity<>(userPlaylistServiceImpl.deleteSongFromUserPlaylist(emailId,songId),HttpStatus.OK);
    }

    //[GET]
    //http://localhost:3333/playlist-app/v1/display-all-playlist-songs/adadarsh22@gmail.com
    @GetMapping("/display-all-playlist-songs/{emailId}")
    public ResponseEntity<?>displayAllSongsInPlaylist(@PathVariable String emailId){
        return new ResponseEntity<>(userPlaylistServiceImpl.displayAllPlaylistSong(emailId),HttpStatus.OK);
    }
}
