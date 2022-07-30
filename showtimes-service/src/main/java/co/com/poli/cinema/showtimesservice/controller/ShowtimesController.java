package co.com.poli.cinema.showtimesservice.controller;

import co.com.poli.cinema.showtimesservice.helpers.Response;
import co.com.poli.cinema.showtimesservice.helpers.ResponseBuild;
import co.com.poli.cinema.showtimesservice.persistence.entity.Showtimes;
import co.com.poli.cinema.showtimesservice.service.ShowtimesDTO.ShowtimesDTO;
import co.com.poli.cinema.showtimesservice.service.ShowtimesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimesController {

    private final ShowtimesServiceImpl showtimesServiceImp;
    private final ResponseBuild builder;
    @GetMapping
    public Response getShowtimes() {
        return builder.success(
                this.showtimesServiceImp.findAll());
    }

    @PostMapping
    public Response saveShowtimes(@RequestBody ShowtimesDTO showtimesDTO) {

        return builder.success(
                this.showtimesServiceImp.saveShowtime(showtimesDTO));

    }

    @GetMapping("/{id}")
    public Response getShowtime(@PathVariable("id") Long id) {

        return builder.success(this.showtimesServiceImp.getShowtime(id));

    }


    @PutMapping("/{id}")
    public Response putShowtimes(@PathVariable("id") Long id, @RequestBody ShowtimesDTO showtimesDTO) {

        return builder.success(this.showtimesServiceImp.putShowtime(id, showtimesDTO));


    }

}
