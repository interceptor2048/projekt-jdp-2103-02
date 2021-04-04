package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @GetMapping(value = "getUser")
    public UserDto getUser(Long id) {
        return new UserDto(1L, "tester", 1, 123, LocalDate.of(2000,1,11) );
    }

    @GetMapping(value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteUser(Long id) {
    }

    @PutMapping(value = "updateUser")
    public UserDto updateUser(UserDto userDto) {
        return new UserDto(1L, "tester", 1, 123, LocalDate.of(2000,2,10));
    }

    @PostMapping(value = "createUser")
    public void createUser(UserDto userDto) {
    }


}
