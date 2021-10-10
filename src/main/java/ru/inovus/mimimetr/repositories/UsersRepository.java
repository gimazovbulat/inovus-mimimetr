package ru.inovus.mimimetr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inovus.mimimetr.model.entity.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
