package co.com.poli.cinema.bookingsservice.clientFeign;

import co.com.poli.cinema.bookingsservice.helpers.Response;
import co.com.poli.cinema.bookingsservice.helpers.ResponseBuild;
import co.com.poli.cinema.bookingsservice.models.Showtime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShowtimeClientImplHystrixCallback implements ShowtimeClient{

    private final ResponseBuild builder;

    @Override
    public Response findById(Long id) {
        return builder.success(new Showtime());
    }
}
