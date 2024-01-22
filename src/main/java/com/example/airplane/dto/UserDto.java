package com.example.airplane.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String id;
    private String password1;
    private String password2;
    private String name;
    private String address;
    private String email;
}
