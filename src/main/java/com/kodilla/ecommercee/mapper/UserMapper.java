package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserMapper {
    public User mapToUser(UserDto userDto) {
        return new User(userDto.getUserId(),
                userDto.getUserName(),
                userDto.isStatus(),
                userDto.getUserKey());
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getUserId(),
                user.getUserName(),
                user.isStatus(),
                user.getUserKey());
    }

    public List<User> mapToUserList(List<UserDto> userDtoList) {
        return userDtoList.stream()
                .map(this::mapToUser)
                .collect(Collectors.toList());
    }

    public List<UserDto> mapToUserDtoList(List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
