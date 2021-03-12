package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.beans.ManagedBean;

@ManagedBean
public class Album {
	private String title;
	private String artist;
	private int year;
	private List<Track> tracks;
	
	public Album() {
		this.setTitle("");
		this.setArtist("");
		this.setYear(0);
		this.setTracks(new ArrayList<Track>());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
}
