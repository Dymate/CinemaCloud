package co.com.poli.cinema.showtimesservice.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ShowtimesCloudExceptions extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public ShowtimesCloudExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
