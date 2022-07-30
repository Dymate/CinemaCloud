package co.com.poli.cinema.bookingsservice.controller;

import co.com.poli.cinema.bookingsservice.helpers.Response;
import co.com.poli.cinema.bookingsservice.helpers.ResponseBuild;
import co.com.poli.cinema.bookingsservice.persistence.entity.Bookings;
import co.com.poli.cinema.bookingsservice.service.BookingsService;
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

    private final BookingsService bookingsService;
    private final ResponseBuild builder;

    @GetMapping
    public Response getBookings() {
        return this.builder.success(this.bookingsService.findAll());
    }

    @PostMapping
    public Response saveBookings(@RequestBody BookingsDTO bookingsDTO) {

        return builder.success(
                this.bookingsService.saveBookings(bookingsDTO));

    }

    @GetMapping("/{id}")
    public Response getBookingById(@PathVariable("id") Long id) {

        return builder.success(this.bookingsService.getBookingById(id));

    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {

        return builder.success(this.bookingsService.deleteBookings(id));


    }

    @GetMapping("user/{userId}")
    public Response getBookingsByUserId(@PathVariable("userId") Long userId) {

        return builder.success(this.bookingsService.getBookingsByUserId(userId));


    }

}
