package co.com.poli.cinema.userservices.service;

import co.com.poli.cinema.userservices.persistence.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<User> findAll();

    String saveUser(User user);

    String deleteUser(Long id);





}
