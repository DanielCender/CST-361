package business;

import beans.Album;
import data.DataAccessInterface;
import util.AlbumNotFoundException;
import util.TracksNotFoundException;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Session Bean implementation class MusicManager
 */
@Stateless
@Local(MusicManagerInterface.class)
@LocalBean
public class MusicManager implements MusicManagerInterface {
	@EJB
    DataAccessInterface<Album> dao;
    @Inject
	TrackFinderInterface tf;
	
    /**
     * Default constructor. 
     */
    public MusicManager() {}

	/**
     * @see MusicManagerInterface#addAlbum(Album)
     */
    public Album addAlbum(Album album) {
    	Album created = this.dao.create(album);
    	if(created.getTracks().size() == 0) throw new TracksNotFoundException("No tracks to be found for this album");
		return created;
    }

	public Album getAlbum(Album album) {
		Album found = this.dao.findBy(album);
		if(found == null) throw new AlbumNotFoundException("Could not find album with search parameters");
		return found;
	}
}
