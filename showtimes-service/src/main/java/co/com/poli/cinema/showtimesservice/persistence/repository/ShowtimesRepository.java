package co.com.poli.cinema.showtimesservice.persistence.repository;

import co.com.poli.cinema.showtimesservice.persistence.entity.Showtimes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimesRepository extends JpaRepository<Showtimes, Long> {
}
