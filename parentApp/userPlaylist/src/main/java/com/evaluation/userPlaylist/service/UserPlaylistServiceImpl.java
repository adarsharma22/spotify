package com.evaluation.userPlaylist.service;

import com.evaluation.userPlaylist.model.Song;
import com.evaluation.userPlaylist.model.UserPlaylist;
import com.evaluation.userPlaylist.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPlaylistServiceImpl implements PlaylistService{
    @Autowired
    private PlayListRepository playListRepository;

    @Override
    public UserPlaylist addUser(UserPlaylist userPlaylist) {
        userPlaylist.setSongs(new ArrayList<Song>());
        return playListRepository.insert(userPlaylist);
    }

    @Override
    public List<Song> addSongToUserPlaylist(String emailId, Song song) {
        UserPlaylist user=playListRepository.findById(emailId).get();
        user.getSongs().add(song);
        playListRepository.save(user);
        List<Song>songlist=user.getSongs();
        return songlist;
    }

    @Override
    public boolean deleteSongFromUserPlaylist(String emailId, String songId) {
        UserPlaylist user=playListRepository.findById(emailId).get();
        List<Song>allSong=user.getSongs();
        for(int i=0;i< allSong.size();i++){
            if(songId.equals(allSong.get(i).getSongId())){

                allSong.remove(i);
                playListRepository.save(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Song> displayAllPlaylistSong(String emailId) {
        UserPlaylist user=playListRepository.findById(emailId).get();
        List<Song>allSong=user.getSongs();
        return allSong;
    }
}
