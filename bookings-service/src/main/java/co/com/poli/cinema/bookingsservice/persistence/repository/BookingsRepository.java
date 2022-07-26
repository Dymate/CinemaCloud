package co.com.poli.cinema.bookingsservice.persistence.repository;

import co.com.poli.cinema.bookingsservice.persistence.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {

    List<Bookings> findAllByUserId(Long userId);

}
