package com.manmo.chinesemealordering.controller;

import com.manmo.chinesemealordering.dto.UserRegisterDTO;
import com.manmo.chinesemealordering.entity.User;
import com.manmo.chinesemealordering.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserServiceImpl userService;

    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    public User register(@RequestBody @Valid UserRegisterDTO userRegisterDTO) {
        return userService.register(userRegisterDTO);
    }
}
