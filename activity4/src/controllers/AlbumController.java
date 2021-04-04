package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Album;
import business.MusicManager;
import util.TracksNotFoundException;

@ManagedBean
@ViewScoped
public class AlbumController {
//	@Inject
//	private MusicManager musicManager;
	
	public String onSubmit(Album album) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
		MusicManager musicManager = new MusicManager();
		Album a = musicManager.addAlbum(album);
		System.out.println("Printing to the console.");
		} catch(TracksNotFoundException e) {
			System.out.println(e.getMessage());
		}
		ctx.getExternalContext().getRequestMap().put("album", album);
		ctx.getExternalContext().getRequestMap().put("trackCount", album.getNumberTracks());
		
		return "AddAlbumResponse.xhtml";
	}
}
