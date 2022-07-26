package co.com.poli.cinema.bookingsservice.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private Long userId;


    @Column
    private Long showtime;


    @Column
    private Long movie;

    public Bookings(Long showtimeId, Long userid, Long movie) {
        this.showtime = showtimeId;
        this.userId = userid;
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookings bookings = (Bookings) o;
        return Objects.equals(id, bookings.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }


}