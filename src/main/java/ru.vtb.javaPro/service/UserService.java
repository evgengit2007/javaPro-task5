package ru.vtb.javaPro.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.vtb.javaPro.entity.User;
import ru.vtb.javaPro.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        findAll().forEach(user -> log.info(user.toString()));   // �������� ��� ������
        User user = findUserById(1L);                           // �������� ������ �� id
        log.info("Found user for id {} : " + user.toString(), 1L);
        log.info("Add user for username Leonid");
        insertUser("Leonid");                            // �������� ������ �� username
        log.info("Add user for username Vladislav");
        user = insertUser("Vladislav");                    // �������� 2-� ������ �� username
        log.info("Delete user for username {}: " + user.toString(), user.getUsername());
        deleteUser(user);                                       // ������� ������
        user = findUserByName("Evgen");                         // �������� ������ �� username
        log.info("Update user for username {}: " + user.toString(), user.getUsername());
        updateUsernameById(1L, "EvgenUpdate");          // �������� ������ �� id
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public User findUserByName(String name) {
        return userRepository.findUserByUsername(name).orElseThrow(EntityNotFoundException::new);
    }

    public User insertUser(String name) {
        User user = new User();
        user.setUsername(name);
        userRepository.save(user);
        return findUserByName(name);
    }

    public User updateUsernameById(Long id, String name) {
        User user = findUserById(id);
        user.setUsername(name);
        userRepository.save(user);
        return user;
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}
