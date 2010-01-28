package com.medratech.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.medratech.spring.dao.GenericJpaDao;
import com.medratech.spring.model.impl.Song;

@Repository
public class JpaSongDao extends GenericJpaDao<Song, Long> implements SongDao {}
