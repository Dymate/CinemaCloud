package co.com.poli.cinema.showtimesservice.service;

import co.com.poli.cinema.showtimesservice.exceptions.ShowtimesCloudExceptions;
import co.com.poli.cinema.showtimesservice.feign.MoviesClient;
import co.com.poli.cinema.showtimesservice.model.Movies;
import co.com.poli.cinema.showtimesservice.persistence.entity.Showtimes;
import co.com.poli.cinema.showtimesservice.persistence.repository.ShowtimesRepository;
import co.com.poli.cinema.showtimesservice.service.ShowtimesDTO.ShowtimesDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowtimesServiceImpl implements ShowtimesService {

    private final ShowtimesRepository showtimesRepository;
    private final MoviesClient moviesClient;


    @Override
    @Transactional(readOnly = true)
    public List<Showtimes> findAll() {

        return showtimesRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveShowtime(ShowtimesDTO showtimesDTO) {

        Showtimes showtimes = new Showtimes(showtimesDTO.getIdMovie(), showtimesDTO.getDate());

        showtimesRepository.save(showtimes);

        return "Funcion creada";
    }

    @Override
    public Showtimes getShowtime(Long id) {
        Optional<Showtimes> optionalShowtimes = showtimesRepository.findById(id);
        if (optionalShowtimes.isPresent()) {
            return optionalShowtimes.get();
        } else {
            throw new ShowtimesCloudExceptions("No existe una funcion con ese id", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Showtimes putShowtime(Long id, ShowtimesDTO showtimesDTO) {
        Optional<Showtimes> optionalShowtimes = showtimesRepository.findById(id);
        if (optionalShowtimes.isPresent()) {

            if (showtimesDTO.getIdMovie() != null) {
                optionalShowtimes.get().setMovies(id);
            }

            if (showtimesDTO.getDate() != null) {
                optionalShowtimes.get().setDate(showtimesDTO.getDate());
            }

        }
        return showtimesRepository.save(optionalShowtimes.get());
    }
}
