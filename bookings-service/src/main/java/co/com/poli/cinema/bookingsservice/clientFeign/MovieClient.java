package co.com.poli.cinema.bookingsservice.clientFeign;

import co.com.poli.cinema.bookingsservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movies-service", fallback =MovieClientImplHystrixCallback.class )
public interface MovieClient {

    @GetMapping("/cinema_cloud/v1/movies/{id}")
    Response findById(@PathVariable Long id);

}

