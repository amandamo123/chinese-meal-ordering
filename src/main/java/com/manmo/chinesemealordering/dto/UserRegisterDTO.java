package com.manmo.chinesemealordering.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class UserRegisterDTO {
    @NotBlank(message = "username can not be empty!")
    private String username;
    @NotBlank(message = "password can not be empty!")
    private String password;
    @Email(message = "register email address is invalid!")
    private String email;
    @NotBlank(message = "mobile can not be empty!")
    private String mobile;
}
