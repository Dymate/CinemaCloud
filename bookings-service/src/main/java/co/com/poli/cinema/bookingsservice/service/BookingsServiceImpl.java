package co.com.poli.cinema.bookingsservice.service;

import co.com.poli.cinema.bookingsservice.clientFeign.MovieClient;
import co.com.poli.cinema.bookingsservice.clientFeign.ShowtimeClient;
import co.com.poli.cinema.bookingsservice.clientFeign.UserClient;
import co.com.poli.cinema.bookingsservice.exceptions.BookingsCloudExceptions;
import co.com.poli.cinema.bookingsservice.models.Movie;
import co.com.poli.cinema.bookingsservice.models.Showtime;
import co.com.poli.cinema.bookingsservice.models.User;
import co.com.poli.cinema.bookingsservice.persistence.entity.Bookings;
import co.com.poli.cinema.bookingsservice.persistence.repository.BookingsRepository;
import co.com.poli.cinema.bookingsservice.service.DTO.BookingsDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsService {

    private final BookingsRepository bookingsRepository;
    private final UserClient userClient;
    private final ShowtimeClient showtimeClient;
    private final MovieClient movieClient;

    @Override
    @Transactional(readOnly = true)
    public List<Bookings> findAll() {
        return bookingsRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveBookings(BookingsDTO bookingsDTO) {
        ModelMapper modelMapper = new ModelMapper();
        try {
            User user = modelMapper.map(userClient.findById(bookingsDTO.getUserid()).getData(), User.class);
            System.out.println(user.toString());
            Movie movie = modelMapper.map(movieClient.findById(bookingsDTO.getMovieid()).getData(), Movie.class);
            System.out.println(movie.toString());
            Showtime showtime = modelMapper.map(showtimeClient.findById(bookingsDTO.getShowtimeid()).getData(), Showtime.class);
            showtime.setMovie(movie);
            System.out.println(showtime.toString());

            Bookings bookings = new Bookings(bookingsDTO.getUserid(),user,bookingsDTO.getShowtimeid(),showtime,bookingsDTO.getMovieid());
            bookingsRepository.save(bookings);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new BookingsCloudExceptions("Los datos recibidos no existen", HttpStatus.BAD_REQUEST);
        }


        return "Reserva creada";
    }

    @Override
    public Bookings getBookingById(Long id) {
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
    public List<Bookings> getBookingsByUserId(Long userId) {
        List<Bookings> bookingsList = bookingsRepository.findAllByUserId(userId);
        if (bookingsList.isEmpty()) {
            throw new BookingsCloudExceptions("Este usuario no tiene resarvas", HttpStatus.BAD_REQUEST);
        } else {
            return bookingsList;
        }
    }
}