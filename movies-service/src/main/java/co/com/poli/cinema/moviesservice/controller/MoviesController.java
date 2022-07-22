package co.com.poli.cinema.moviesservice.controller;

import co.com.poli.cinema.moviesservice.persistence.entity.Movies;
import co.com.poli.cinema.moviesservice.service.DTO.MoviesDTO;
import co.com.poli.cinema.moviesservice.service.MoviesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MoviesServiceImpl moviesServiceImp;

    @GetMapping
    public ResponseEntity<List<Movies>> getMovies() {
        return new ResponseEntity<>(
                this.moviesServiceImp.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveMovies(@RequestBody MoviesDTO moviesDTO) {

        return new ResponseEntity<>(
                this.moviesServiceImp.saveMovies(moviesDTO), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovie(@PathVariable("id") Long id){

        return new ResponseEntity<>(this.moviesServiceImp.getMovie(id), HttpStatus.OK);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.moviesServiceImp.deleteMovies(id), HttpStatus.OK);


    }


}
