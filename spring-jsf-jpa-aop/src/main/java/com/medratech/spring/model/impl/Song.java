package com.medratech.spring.model.impl;

import javax.persistence.Entity;

import com.medratech.spring.model.Model;

@Entity
public class Song extends Model {

	private static final long serialVersionUID = -450572622610037574L;

	private String title;
    
    private String artist;
    
    private String genre;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
