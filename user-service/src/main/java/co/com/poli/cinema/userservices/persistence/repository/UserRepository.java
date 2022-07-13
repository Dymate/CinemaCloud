package co.com.poli.cinema.userservices.persistence.repository;

import co.com.poli.cinema.userservices.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findAllById(Long id);


}
