package springboot.movieAPI.module;

import java.util.Date;

import lombok.Data;

@Data
public class MovieDTO {
    
    private Item[] items;
    
    @Data
    static class Item {
        public String title;
        public String link;
        public String image;
        public String subtitle;
        public String pubDate;
        public String director;
        public String actor;
        public float userRating;
    }
}
