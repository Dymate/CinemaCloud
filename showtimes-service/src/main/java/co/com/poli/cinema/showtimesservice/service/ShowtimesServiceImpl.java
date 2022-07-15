package co.com.poli.cinema.showtimesservice.service;

import co.com.poli.cinema.showtimesservice.exceptions.ShowtimesCloudExceptions;
import co.com.poli.cinema.showtimesservice.persistence.entity.Showtimes;
import co.com.poli.cinema.showtimesservice.persistence.repository.ShowtimesRepository;
import co.com.poli.cinema.showtimesservice.service.ShowtimesDTO.ShowtimesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowtimesServiceImpl implements ShowtimesService {

    private final ShowtimesRepository showtimesRepository;
    private final MoviesRepository moviesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Showtimes> findAll() {
        return showtimesRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveShowtime(ShowtimesDTO showtimesDTO) {
        Optional<Movies> movies = moviesRepository.findById(showtimesDTO.getIdMovie());
        if (movies.isPresent()) {
            Showtimes showtimes = new Showtimes(showtimesDTO.getDate(), movies.get());
            showtimesRepository.save(showtimes);
            return "Funcion creada con exito!";
        } else {
            throw new ShowtimesCloudExceptions("No hay pelicula con ese id", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public Showtimes getShowtime(Long id) {
        Optional<Showtimes> optionalShowtimes = showtimesRepository.findById(id);
        if (optionalShowtimes.isPresent()){
            return optionalShowtimes.get();
        }else{
            throw new ShowtimesCloudExceptions("No existe una funcion con ese id", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public String deleteShowtime(Long id) {
        Optional<Showtimes> optionalShowtimes = showtimesRepository.findById(id);
        if (optionalShowtimes.isPresent()) {
            Showtimes showtimes = optionalShowtimes.get();
            if (showtimes.getBookingsList().isEmpty()) {
                showtimesRepository.deleteById(id);
                return "Funcion eliminada";
            } else {
                throw new ShowtimesCloudExceptions("La funcion no debe tener reservas asosciadas para eliminar", HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new ShowtimesCloudExceptions("No se encontro la funcion con ese id", HttpStatus.NOT_FOUND);
        }
    }
}
