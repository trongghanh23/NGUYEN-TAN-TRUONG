package com.code.song.service.impl;

import com.code.song.model.Song;
import com.code.song.repository.ISongRepository;
import com.code.song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public List<Song> songList() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);

    }

    @Override
    public Song getId(Integer id) {
        return iSongRepository.findById(id).orElse(null);
    }


}
