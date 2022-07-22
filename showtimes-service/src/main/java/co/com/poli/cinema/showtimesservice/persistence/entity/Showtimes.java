package co.com.poli.cinema.showtimesservice.persistence.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


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

    @Transient
    @Column(nullable = false)
    private Long movies;

    public Showtimes(Long idMovie, LocalDate date) {
        this.date = date;
        this.movies = idMovie;
    }



}
