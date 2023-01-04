package ru.yandex.practicum.later.laterV3.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    User save(User user);
    //List<User> searchByEmail(String domain);
}
