package co.com.poli.cinema.bookingsservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.time.LocalDate;

@Data
public class Showtime {

    private Long id;
    private LocalDate date;
    private Movie movie;

}
