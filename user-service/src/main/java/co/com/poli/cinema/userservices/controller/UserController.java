package co.com.poli.cinema.userservices.controller;

import co.com.poli.cinema.userservices.helpers.Response;
import co.com.poli.cinema.userservices.helpers.ResponseBuild;
import co.com.poli.cinema.userservices.persistence.entity.User;
import co.com.poli.cinema.userservices.service.DTO.UserDTO;
import co.com.poli.cinema.userservices.service.UserService;
import co.com.poli.cinema.userservices.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity<List<User>>(this.userServiceImpl.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO) {

        return new ResponseEntity<String>(this.userServiceImpl.saveUser(userDTO), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {

        return new ResponseEntity<String>(this.userServiceImpl.deleteUser(id), HttpStatus.OK);


    }

}
