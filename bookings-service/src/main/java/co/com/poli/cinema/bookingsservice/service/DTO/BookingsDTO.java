package co.com.poli.cinema.bookingsservice.service.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BookingsDTO {

    private Long userid;
    private Long showtimeid;
    private Long movieid;

}
