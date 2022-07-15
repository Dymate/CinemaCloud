package co.com.poli.cinema.moviesservice.service;

import co.com.poli.cinema.moviesservice.exceptions.MoviesCloudExceptions;
import co.com.poli.cinema.moviesservice.persistence.entity.Movies;
import co.com.poli.cinema.moviesservice.persistence.repository.MoviesRepository;
import co.com.poli.cinema.moviesservice.service.DTO.MoviesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoviesServiceImpl implements MoviesService {


    private final MoviesRepository moviesRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Movies> findAll() {
        return moviesRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveMovies(MoviesDTO moviesDTO) {
        Movies movies = new Movies(moviesDTO.getTitle(), moviesDTO.getDirector(), moviesDTO.getRating());
        moviesRepository.save(movies);
        return "pelicula creada";
    }

    @Override
    public Movies getMovie(Long id) {
        Optional<Movies> optionalMovies = moviesRepository.findById(id);
        if (optionalMovies.isPresent()){
            return optionalMovies.get();
        }else{
           throw new MoviesCloudExceptions("No existe una pelicula con ese id", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteMovies(Long id) {
        Optional<Movies> optionalMovies = moviesRepository.findById(id);
        if (optionalMovies.isPresent()) {
            Movies movies = optionalMovies.get();
            if (movies.showtimesList().isEmpty()) {
                moviesRepository.deleteById(id);
                return "Pelicula eliminada";
            } else {
                throw new MoviesCloudExceptions("La pelicula no debe tener funciones asosciadas para eliminar", HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new MoviesCloudExceptions("No se encontro la pelicula con ese id", HttpStatus.NOT_FOUND);
        }
    }
}
