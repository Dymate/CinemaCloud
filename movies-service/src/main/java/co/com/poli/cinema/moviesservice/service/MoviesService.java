package co.com.poli.cinema.moviesservice.service;

import co.com.poli.cinema.moviesservice.persistence.entity.Movies;
import co.com.poli.cinema.moviesservice.service.DTO.MoviesDTO;

import java.util.List;
import java.util.Optional;

public interface MoviesService {

    List<Movies> findAll();

    String saveMovies(MoviesDTO moviesDTO);

    Movies getMovie(Long id);

    String deleteMovies(Long id);





}
