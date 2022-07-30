package co.com.poli.cinema.bookingsservice.models;

import lombok.Data;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
public class Movie {

    private Long id;


    private String title;


    private String director;


    private int rating;


    @ElementCollection
    private List<Long> showtimes;

    @ElementCollection
    private List<Long> bookings;
}
