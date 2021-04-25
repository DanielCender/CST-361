package business;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import beans.Album;

/**
 * Session Bean implementation class Cache
 */
@Startup
@Singleton
@LocalBean
public class Cache {
	// String is title#artist#year, concatenated
	private HashMap<String, Album> cache;
    /**
     * Default constructor. 
     */
    public Cache() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    public void init() {
    	cache = new HashMap<String, Album>();
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("Im inside destroy...");
    }
    
    public Album getObject(Album album) {
    	String albumKey = album.getTitle() + "#" + album.getArtist() + "#" + album.getYear();
    	Album found = cache.get(albumKey);
    	return found != null ? album : null;
    }
    
    public void putObject(Album album) {
    	String albumKey = album.getTitle() + "#" + album.getArtist() + "#" + album.getYear();
    	cache.put(albumKey, album);
    	System.out.println("Album placed at: " + albumKey + ", " + this.getObject(album).toString());
    }
}
