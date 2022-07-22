package co.com.poli.cinema.moviesservice.persistence.entity;

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
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMovie", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column
    private String title;

    @Column
    private String director;

    @Column
    private int rating;

    @Transient
    private List<Long> showtimes;

    @Transient
    private List<Long> bookings;


    public Movies(String title, String director, int rating) {
        this.title = title;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return Objects.equals(id, movies.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}
