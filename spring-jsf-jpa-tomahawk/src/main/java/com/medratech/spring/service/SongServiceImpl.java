package com.medratech.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medratech.spring.dao.impl.SongDao;
import com.medratech.spring.model.impl.Song;

@Service
public class SongServiceImpl implements SongService {

	private SongDao songDao;
	
	@Autowired
	public SongServiceImpl(SongDao songDao) {
		this.songDao = songDao;
	}
	
	@Transactional
	public void createNew(Song song) {
		songDao.persist(song);
	}

	@Transactional
	public void remove(Song song) {
		songDao.remove(song);
	}
	
	public List<Song> findAll() {
		return songDao.findAll();
	}

	public Song findById(Long id) {
		return songDao.findById(id);
	}
	
}
