package business;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Album;
import beans.ResponseDataModel;
import util.AlbumNotFoundException;

@RequestScoped
@Path("/music")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class MusicRestService {
	@GET
	@Path("/getalbumj/{title}/{artist}/{year}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDataModel getAlbumj(@PathParam("title") String title, @PathParam("artist") String artist,@PathParam("year") int year) {
		try {
		MusicManager manager = new MusicManager();
		Album album =  manager.getAlbum(new Album(title, artist, year));
		return new ResponseDataModel(0, "", album);
		} catch(AlbumNotFoundException e) {
			return new ResponseDataModel(404, "Could not find the album with filters specified.", null);
		} catch(Exception e) {
			return new ResponseDataModel(500, "We're not really sure what, but something went wrong.", null);
		}
	}
	
	@GET
	@Path("/getalbumx/{title}/{artist}/{year}")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseDataModel getAlbumx(@PathParam("title") String title, @PathParam("artist") String artist,@PathParam("year") int year) {
		try {
		MusicManager manager = new MusicManager();
		Album album =  manager.getAlbum(new Album(title, artist, year));
		return new ResponseDataModel(0, "", album);
		} catch(AlbumNotFoundException e) {
			return new ResponseDataModel(404, "Could not find the album with filters specified.", null);
		} catch(Exception e) {
			return new ResponseDataModel(500, "We're not really sure what, but something went wrong.", null);
		}
	}
}
