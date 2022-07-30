package co.com.poli.cinema.bookingsservice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class User {

    private Long id;

    private String name;

    private String lastname;

    @ElementCollection
    private List<Long> bookings;
}
