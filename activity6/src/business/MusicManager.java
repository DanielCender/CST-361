package business;

import beans.Album;
import data.MusicDataService;
import util.AlbumNotFoundException;
import util.TracksNotFoundException;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MusicManager
 */
// @Stateless
@Local(MusicManagerInterface.class)
@LocalBean
public class MusicManager implements MusicManagerInterface {
    MusicDataService dao;
    /**
     * Default constructor. 
     */
    public MusicManager() {
    	this.dao = new MusicDataService();
    }

	/**
     * @see MusicManagerInterface#addAlbum(Album)
     */
    public Album addAlbum(Album album) {
    	Album created = this.dao.create(album);
    	if(created.getTracks().size() == 0) throw new TracksNotFoundException("No tracks to be found for this album");
		return created;
    }

	@Override
	public Album getAlbum(Album album) {
		Album found = this.dao.findBy(album);
		if(found == null) throw new AlbumNotFoundException("Could not find album with search parameters");
		return found;
	}
}
