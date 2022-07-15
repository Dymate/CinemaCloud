package co.com.poli.cinema.userservices.service;

import co.com.poli.cinema.userservices.persistence.entity.User;
import co.com.poli.cinema.userservices.service.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> findAll();

    String saveUser(UserDTO userDTO);

    String deleteUser(Long id);





}
