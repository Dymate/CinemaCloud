package co.com.poli.cinema.moviesservice.service.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MoviesDTO {

    String title;
    String director;
    int rating;
    Long showtimesId;
    Long bookingsId;

}
