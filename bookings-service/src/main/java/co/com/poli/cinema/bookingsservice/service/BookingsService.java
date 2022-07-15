package co.com.poli.cinema.bookingsservice.service;

import co.com.poli.cinema.bookingsservice.persistence.entity.Bookings;
import co.com.poli.cinema.bookingsservice.service.DTO.BookingsDTO;

import java.util.List;

public interface BookingsService {


    List<Bookings> findAll();

    String saveBookings(BookingsDTO bookingsDTO);

    Bookings getBookings(Long id);

    String deleteBookings(Long id);

    List<Bookings> getBookingsByUserId(Long userid);


}
