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
    @Column(name = "idBookings", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "Users_idUser", nullable = false)
    private Long userid;

    @Transient
    @Column
    private Long showtime;

    @Transient
    @Column
    private Long movie;

    public Bookings(Long showtimeid, Long userid, Long movieid) {
        this.showtime = showtimeid;
        this.userid = userid;
        this.movie = movieid;
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
