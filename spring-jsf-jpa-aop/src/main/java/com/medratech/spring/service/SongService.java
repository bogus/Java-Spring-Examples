package com.medratech.spring.service;

import java.util.List;

import com.medratech.spring.model.impl.Song;

public interface SongService {
	
	public void createNew(Song song);
    
	public List<Song> findAll();
    
    public Song findById(Long id);
    
    public void remove(Song song);
    
}
