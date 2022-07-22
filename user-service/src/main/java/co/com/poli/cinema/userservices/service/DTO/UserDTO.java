package co.com.poli.cinema.userservices.service.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;

@Getter
@RequiredArgsConstructor
public class UserDTO {

    String name;
    String lastname;
    Long bookingsID;

}
