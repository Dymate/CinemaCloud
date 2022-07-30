package co.com.poli.cinema.bookingsservice.clientFeign;

import co.com.poli.cinema.bookingsservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "showtimes-service", fallback =ShowtimeClientImplHystrixCallback.class )
public interface ShowtimeClient {
    @GetMapping("/cinema_cloud/v1/showtimes/{id}")
    Response findById(@PathVariable Long id);
}
