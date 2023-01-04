package ru.yandex.practicum.later.laterV3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    //{{baseUrl}}/users
    /*{
        "fullName": "Elena Bilunova",
        "email": "user@user.com",
        "registrationDate": "2023.01.01, 10:11:44"
    }*/

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    //{{baseUrl}}/users/search?domain=yandex.ru
    @GetMapping("/search")
    public List<UserDto> searchByEmailDomain(@RequestParam String domain) {
        return userService.searchByEmailDomain(domain);
    }
}