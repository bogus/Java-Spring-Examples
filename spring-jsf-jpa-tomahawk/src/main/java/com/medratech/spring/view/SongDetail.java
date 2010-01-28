package com.medratech.spring.view;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.medratech.spring.model.impl.Song;
import com.medratech.spring.service.SongService;

@Component("songDetail")
@Scope("request")
public class SongDetail {

	private SongService songService;
	
	private Song song = new Song();
	
	@Autowired
	public SongDetail(SongService songService) {
		this.songService = songService;
		if(((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).
				getSession().getAttribute("song") != null)
			song = (Song)((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext()
							.getRequest()).getSession().getAttribute("song");
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
	
	public String back() {
		return "createSong";
	}
	
}
