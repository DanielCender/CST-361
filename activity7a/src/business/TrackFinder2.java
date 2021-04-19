package business;

import beans.Album;
import beans.Track;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TrackFinder2
 */
@Stateless
@Local(TrackFinderInterface.class)
@LocalBean
public class TrackFinder2 implements TrackFinderInterface {

    /**
     * Default constructor. 
     */
    public TrackFinder2() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see TrackFinderInterface#getTracks(Album)
     */
    public List<Track> getTracks(Album album) {
        // TODO Auto-generated method stub
			return null;
    }

}
