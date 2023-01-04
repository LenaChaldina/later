package ru.yandex.practicum.later.laterV3.user;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class UserMapper {
    private static final String PATTERN_FORMAT = "yyyy.MM.dd, HH:mm:ss";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT);
    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getFirstName() + "," + user.getLastName(),
                user.getEmail(),
                formatter.format(LocalDateTime.ofInstant(user.getRegistrationDate(), ZoneOffset.UTC))
                //редставьте в виде строки с датой в формате yyyy.MM.dd, hh:mm:ss.
               // formatter.format(user.getRegistrationDate())
        );
    }

    public static User toDtoUser(UserDto userDto) {
        String[] fullName = userDto.getFullName().split(",");
        TemporalAccessor t = formatter.parse(userDto.getRegistrationDate());

        return new User(
                fullName[0],
                fullName[1],
                userDto.getEmail(),
                LocalDateTime.from(t).toInstant(ZoneOffset.UTC)
                //formatter.parse(userDto.getRegistrationDate())));
        );
    }
}
