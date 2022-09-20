package com.code.song.service;

import com.code.song.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> songList();

    void save(Song song);

    Song getId(Integer id);
}
