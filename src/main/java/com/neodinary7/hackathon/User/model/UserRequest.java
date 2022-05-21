package com.neodinary7.hackathon.User.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRequest {
    private final String name;
    private final String email;
    private final String password;
}
