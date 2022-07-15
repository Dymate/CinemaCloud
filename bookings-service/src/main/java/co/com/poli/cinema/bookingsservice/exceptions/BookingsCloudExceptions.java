package co.com.poli.cinema.bookingsservice.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BookingsCloudExceptions extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public BookingsCloudExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
