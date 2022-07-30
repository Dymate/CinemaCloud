package co.com.poli.cinema.userservices.controller;

import co.com.poli.cinema.userservices.helpers.Response;
import co.com.poli.cinema.userservices.helpers.ResponseBuild;
import co.com.poli.cinema.userservices.service.DTO.UserDTO;
import co.com.poli.cinema.userservices.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final ResponseBuild builder;
    @GetMapping
    public Response getUser() {
        return builder.success(
                this.userServiceImpl.findAll());
    }

    @PostMapping
    public Response saveUser(@RequestBody UserDTO userDTO) {

        return builder.success(this.userServiceImpl.saveUser(userDTO));

    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {

        return builder.success(this.userServiceImpl.deleteUser(id));
    }

    @GetMapping("/{id}")
    public Response getUserById(@PathVariable Long id){
        return builder.success(userServiceImpl.findUserById(id));
    }
}
