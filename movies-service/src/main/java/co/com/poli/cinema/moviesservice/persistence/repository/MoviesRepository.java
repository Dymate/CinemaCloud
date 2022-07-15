package co.com.poli.cinema.moviesservice.persistence.repository;

import co.com.poli.cinema.moviesservice.persistence.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
}
