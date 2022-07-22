package co.com.poli.cinema.bookingsservice.controller;

import co.com.poli.cinema.bookingsservice.persistence.entity.Bookings;
import co.com.poli.cinema.bookingsservice.service.BookingsServiceImpl;
import co.com.poli.cinema.bookingsservice.service.DTO.BookingsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingsController {

    private final BookingsServiceImpl bookingsServiceImpl;

    @GetMapping
    public ResponseEntity<List<Bookings>> getBookings() {
        return new ResponseEntity<>(this.bookingsServiceImpl.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveShowtimes(@RequestBody BookingsDTO bookingsDTO) {

        return new ResponseEntity<>(
                this.bookingsServiceImpl.saveBookings(bookingsDTO), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookings> getMovie(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.bookingsServiceImpl.getBookings(id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.bookingsServiceImpl.deleteBookings(id), HttpStatus.OK);


    }

    @GetMapping("/{userid}")
    public ResponseEntity<List<Bookings>> getShowtimeUserId(@PathVariable("userid") Long userid) {

        return new ResponseEntity<>(this.bookingsServiceImpl.getBookingsByUserId(userid), HttpStatus.OK);


    }

}
