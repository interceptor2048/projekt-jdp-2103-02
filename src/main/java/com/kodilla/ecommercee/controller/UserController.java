package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/user")
public class UserController {
    private final UserDbService dbService;
    private final UserMapper mapper;

    @GetMapping(value = "getUser")
    public UserDto getUser(@RequestParam Long id) throws UserNotFoundException {
        return mapper.mapToUserDto(dbService.getUserById(id).orElseThrow(UserNotFoundException::new));
    }

    @GetMapping(value = "getUsers")
    public List<UserDto> getUsers() {
        return mapper.mapToUserDtoList(dbService.getAllUsers());
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteUser(@RequestParam Long id) {
        dbService.deleteUserById(id);
    }

    @PutMapping(value = "updateUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User updateUser = mapper.mapToUser(userDto);
        User saveUser = dbService.save(updateUser);
        return mapper.mapToUserDto(saveUser);
    }

    @PostMapping(value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        User user = mapper.mapToUser(userDto);
        user.setExpirationDate(LocalDateTime.now());
        dbService.save(mapper.mapToUser(userDto));
    }

    @PutMapping(value = "banUser")
    public UserDto banUser(@RequestParam Long id) throws UserNotFoundException {
        User banUser = dbService.getUserById(id).orElseThrow(UserNotFoundException::new);
        banUser.setStatus(false);
        User saveUser = dbService.save(banUser);
        return mapper.mapToUserDto(saveUser);
    }

    @PutMapping(value = "randomUserKey")
    public UserDto randomUserKey(@RequestParam Long id) throws UserNotFoundException {
        User userWithNewKey = dbService.getUserById(id).orElseThrow(UserNotFoundException::new);
        userWithNewKey.setUserKey(userWithNewKey.generateUserKey());
        User saveUserWithNewKey = dbService.save(userWithNewKey);
        return mapper.mapToUserDto(saveUserWithNewKey);
    }
}
