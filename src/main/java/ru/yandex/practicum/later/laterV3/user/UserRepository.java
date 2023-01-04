package ru.yandex.practicum.later.laterV3.user;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User save(User user);
    List<User> searchByEmailDomain(String domain);
}
