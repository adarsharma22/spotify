package com.evaluation.userPlaylist.service;

import com.evaluation.userPlaylist.model.Song;
import com.evaluation.userPlaylist.model.UserPlaylist;

import java.util.List;

public interface PlaylistService {
    public UserPlaylist addUser(UserPlaylist userPlaylist);
    public List<Song> addSongToUserPlaylist(String emailId,Song song);
    public boolean deleteSongFromUserPlaylist(String emailId,String songId);
    public List<Song>displayAllPlaylistSong(String emailId);
}
