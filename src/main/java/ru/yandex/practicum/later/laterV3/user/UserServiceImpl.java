package ru.yandex.practicum.later.laterV3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.toDtoUser(userDto);
        User u = repository.save(user);
        return UserMapper.toUserDto(u);
    }

    @Override
    public List<UserDto> searchByEmailDomain(String domain) {
        List<User> users = repository.searchByEmailDomain(domain);
        List<UserDto> usersDto = users.stream().map(user -> UserMapper.toUserDto(user)).collect(Collectors.toList());
        return usersDto;
    }
}