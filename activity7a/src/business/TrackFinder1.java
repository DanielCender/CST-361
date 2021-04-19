package business;

import beans.Album;
import beans.Track;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class TrackFinder1
 */
@Stateless
@Local(TrackFinderInterface.class)
@Alternative
@LocalBean
public class TrackFinder1 implements TrackFinderInterface {
	
    /**
     * Default constructor. 
     */
    public TrackFinder1() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see TrackFinderInterface#getTracks(Album)
     */
    public List<Track> getTracks(Album album) {
			return Storage.getMap().get(album);
    }

}
