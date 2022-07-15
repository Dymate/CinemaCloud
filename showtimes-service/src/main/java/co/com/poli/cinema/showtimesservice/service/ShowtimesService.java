package co.com.poli.cinema.showtimesservice.service;

import co.com.poli.cinema.showtimesservice.persistence.entity.Showtimes;
import co.com.poli.cinema.showtimesservice.service.ShowtimesDTO.ShowtimesDTO;

import java.util.List;
import java.util.Optional;

public interface ShowtimesService {

    List<Showtimes> findAll();

    String saveShowtime(ShowtimesDTO showtimesDTO);

    Showtimes getShowtime(Long id);

    String deleteShowtime(Long id);


}
