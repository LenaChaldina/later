package ru.yandex.practicum.later.laterV3.user;

import java.util.List;

interface UserService {
    List<User> getAllUsers();
    UserDto saveUser(UserDto userDto);

    List<UserDto> searchByEmailDomain(String domain);
}