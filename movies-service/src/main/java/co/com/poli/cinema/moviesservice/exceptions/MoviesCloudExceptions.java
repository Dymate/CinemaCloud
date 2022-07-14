package co.com.poli.cinema.moviesservice.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UserCloudExceptions extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public UserCloudExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
