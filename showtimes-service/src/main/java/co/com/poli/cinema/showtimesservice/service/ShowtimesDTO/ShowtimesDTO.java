package co.com.poli.cinema.showtimesservice.service.ShowtimesDTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class ShowtimesDTO {

    LocalDate date;
    Long idMovie;


}
