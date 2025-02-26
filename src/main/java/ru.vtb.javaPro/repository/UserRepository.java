package ru.vtb.javaPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vtb.javaPro.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
