package co.com.poli.cinema.showtimesservice.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "showtimes")
public class Showtimes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idShowtime", updatable = false, nullable = false, unique = true)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @OneToMany(mappedBy = "showtimes")
    private private List<Bookings> bookingsList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Movies_idMovie")
    private Movies movie;

    public Showtimes(LocalDate date, Movies movies) {
        this.date = date;
        this.movie = movies;
    }
}
