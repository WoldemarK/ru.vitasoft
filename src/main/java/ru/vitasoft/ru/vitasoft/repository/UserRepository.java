package ru.vitasoft.ru.vitasoft.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitasoft.ru.vitasoft.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
