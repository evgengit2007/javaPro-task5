package ru.vtb.javaPro.service;

import lombok.NoArgsConstructor;
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

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void run(String... args) throws Exception {
        findAll().forEach(user -> log.info(user.toString()));
    }


    /*
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Users insertRow(Users users) {
        userDao.insertData(users);
        return users;
    }

    public List<Users> readAll() {
        List<Users> usersList = userDao.readData();
        return usersList;
    }


    public Users getUser(Long id) {
        return userDao.getUserById(id);
    }

    public Users updateUser(Users users) {
        return userDao.updateData(users);
    }

    public Boolean deleteUser(Users users) {
        return userDao.deleteData(users);
    }
*/
}
