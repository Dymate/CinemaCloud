package co.com.poli.cinema.moviesservice.controller;

import co.com.poli.cinema.moviesservice.helpers.Response;
import co.com.poli.cinema.moviesservice.helpers.ResponseBuild;
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
    private final ResponseBuild builder;
    @GetMapping
    public Response getMovies() {
        return builder.success(
                this.moviesServiceImp.findAll());
    }

    @PostMapping
    public Response saveMovies(@RequestBody MoviesDTO moviesDTO) {

        return builder.success(this.moviesServiceImp.saveMovies(moviesDTO));

    }

    @GetMapping("/{id}")
    public Response getMovie(@PathVariable("id") Long id){

        return builder.success(this.moviesServiceImp.getMovie(id));

    }


    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {

        return builder.success(this.moviesServiceImp.deleteMovies(id));


    }


}
