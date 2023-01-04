package ru.yandex.practicum.later.laterV3.user;

import lombok.Data;

@Data
public class UserDto {
    private String fullName;
    private String email;
    private String registrationDate;

    public UserDto(String fullName, String email, String registrationDate) {
        this.fullName = fullName;
        this.email = email;
        this.registrationDate = registrationDate;
    }
}