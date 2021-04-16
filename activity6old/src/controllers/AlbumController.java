package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Album;
import business.MusicManager;
import util.AlbumNotFoundException;
import util.TracksNotFoundException;

@ManagedBean
@ViewScoped
public class AlbumController {
//	@Inject
//	private MusicManager musicManager;
	
	public String onSubmit(Album album) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		MusicManager musicManager = new MusicManager();
		Album a = musicManager.addAlbum(album);
		System.out.println("Printing to the console.");
		ctx.getExternalContext().getRequestMap().put("album", album);
		ctx.getExternalContext().getRequestMap().put("trackCount", album.getNumberTracks());
		
		return "AddAlbumResponse.xhtml";
	}
	
	public String onFind(Album album) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Album found = null;
		MusicManager musicManager = new MusicManager();
	    found = musicManager.getAlbum(album);
		ctx.getExternalContext().getRequestMap().put("album", found);
		ctx.getExternalContext().getRequestMap().put("trackCount", found.getNumberTracks());
		
		return "AddAlbumResponse.xhtml";
	}
}
