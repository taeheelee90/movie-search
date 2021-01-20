package springboot.movieAPI.module;

import java.util.Date;

import lombok.Data;

@Data
public class MovieDTO {

	private int display;
	private Item[] items;

	// Item is only used within MovieDTO class
	@Data
	static class Item {
		public String title;
		public String link;
		public String image;
		public String subtitle;
		public Date pubDate;
		public String director;
		public String actor;
		public float userRating;
	}
}
