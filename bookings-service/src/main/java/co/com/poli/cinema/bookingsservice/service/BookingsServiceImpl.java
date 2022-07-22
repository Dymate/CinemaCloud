package co.com.poli.cinema.bookingsservice.service;

import co.com.poli.cinema.bookingsservice.exceptions.BookingsCloudExceptions;
import co.com.poli.cinema.bookingsservice.persistence.entity.Bookings;
import co.com.poli.cinema.bookingsservice.persistence.repository.BookingsRepository;
import co.com.poli.cinema.bookingsservice.service.DTO.BookingsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsService {

    private final BookingsRepository bookingsRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Bookings> findAll() {
        return bookingsRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveBookings(BookingsDTO bookingsDTO) {


        Bookings bookings = new Bookings(bookingsDTO.getShowtimeid(), bookingsDTO.getUserid(), bookingsDTO.getMovieid());

        bookingsRepository.save(bookings);


        return "Reserva creada";
    }

    @Override
    public Bookings getBookings(Long id) {
        Optional<Bookings> optionalBookings = bookingsRepository.findById(id);
        if (optionalBookings.isPresent()) {
            return optionalBookings.get();
        } else {
            throw new BookingsCloudExceptions("No existe una reserva con ese id", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public String deleteBookings(Long id) {
        Optional<Bookings> optionalBookings = bookingsRepository.findById(id);
        if (optionalBookings.isPresent()) {
            bookingsRepository.deleteById(id);
            return "Se eliminó la reserva";
        } else {
            throw new BookingsCloudExceptions("No se encontro la funcion con ese id", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Bookings> getBookingsByUserId(Long userid) {
        List<Bookings> bookingsList = bookingsRepository.findAllByUserid(userid);
        if (bookingsList.isEmpty()) {
            throw new BookingsCloudExceptions("Este usuario no tiene resarvas", HttpStatus.BAD_REQUEST);
        } else {
            return bookingsList;
        }
    }
}
