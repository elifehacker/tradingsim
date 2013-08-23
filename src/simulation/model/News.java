package simulation.model;

public class News {

	public String getTime() {
		return time;
	}


	public String getHeadline() {
		return headline;
	}


	public String getLink() {
		return link;
	}


	String time;
	String headline;
	String link;
	
	public News(String time, String headline, String link) {
		super();
		this.time = time;
		this.headline = headline;
		this.link = link;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
