package co.com.poli.cinema.moviesservice.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MoviesCloudExceptions extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public MoviesCloudExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
