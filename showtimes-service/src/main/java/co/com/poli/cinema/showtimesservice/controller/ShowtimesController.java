package co.com.poli.cinema.showtimesservice.controller;

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

    @GetMapping
    public ResponseEntity<List<Showtimes>> getShowtimes() {
        return new ResponseEntity<>(
                this.showtimesServiceImp.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveShowtimes(@RequestBody ShowtimesDTO showtimesDTO) {

        return new ResponseEntity<>(
                this.showtimesServiceImp.saveShowtime(showtimesDTO), HttpStatus.CREATED);

    }

    @PostMapping("/{id}")
    public ResponseEntity<Showtimes> getShowtime(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.showtimesServiceImp.getShowtime(id), HttpStatus.OK);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Showtimes> putShowtimes(@PathVariable("id") Long id, @RequestBody ShowtimesDTO showtimesDTO) {

        return new ResponseEntity<>(this.showtimesServiceImp.putShowtime(id, showtimesDTO), HttpStatus.OK);


    }

}
