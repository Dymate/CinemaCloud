package co.com.poli.cinema.userservices.service;

import co.com.poli.cinema.userservices.exceptions.UserCloudExceptions;
import co.com.poli.cinema.userservices.persistence.entity.User;
import co.com.poli.cinema.userservices.persistence.repository.UserRepository;
import co.com.poli.cinema.userservices.service.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User>findUserById(Long id){
        return userRepository.findById(id);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveUser(UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getLastname());
        if (userDTO.getBookingsID() != null) {
            user.getBookings().add(userDTO.getBookingsID());
        }
        userRepository.save(user);
        return "Usuario creado";

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getBookings().isEmpty()) {
                userRepository.deleteById(id);
                return "Usuario eliminado";
            } else {
                throw new UserCloudExceptions("El usuario no debe tener reservas asosciadas", HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new UserCloudExceptions("No se encontro el usuario con ese id", HttpStatus.NOT_FOUND);
        }
    }
}
