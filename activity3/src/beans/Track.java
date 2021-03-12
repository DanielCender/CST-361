package beans;

public class Track {
	private String title;
	private int number;
	
	public Track() {
		this.setTitle("");
		this.setNumber(0);
//		this.setTitle(t);
//		this.setNumber(n);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
