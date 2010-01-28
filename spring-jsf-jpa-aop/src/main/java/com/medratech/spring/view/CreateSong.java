package com.medratech.spring.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.medratech.spring.model.impl.Song;
import com.medratech.spring.service.SongService;

@Component("createSong")
@Scope("request")
public class CreateSong implements Serializable {

	private static final long serialVersionUID = 4500981688032118235L;

	private SongService songService;
	
	private Song song = new Song();
	
	private List<Song> songList;
	
	private UIData table;
	
	@Autowired
	public CreateSong(SongService songService) {
		this.songService = songService;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
	
	public List<Song> getSongList() {
		if(songList == null)
			songList = songService.findAll();
		return songList;
	}

	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}

	public UIData getTable() {
		return table;
	}

	public void setTable(UIData table) {
		this.table = table;
	}

	public String save() {
		songService.createNew(song);
		songList = songService.findAll();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Song is saved successfully", "OK");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);		
		song = new Song();
		return null;
	}
	
	public String delete() {
		songService.remove((Song)table.getRowData());
		songList = songService.findAll();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Song deleted successfully", "OK");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);		
		song = new Song();
		return null;
	}
	
	public String listSongDetail() {
		((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).
			getSession().setAttribute("song", (Song)table.getRowData());
		return "songDetail";
	}
}
