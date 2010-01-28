package com.medratech.spring.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.medratech.spring.dao.GenericJpaDao;
import com.medratech.spring.model.impl.Song;

@Service
@Repository
public class JpaSongDao extends GenericJpaDao<Song, Long> implements SongDao {}
