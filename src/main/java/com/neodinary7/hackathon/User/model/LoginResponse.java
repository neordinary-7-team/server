package com.neodinary7.hackathon.User.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginResponse {

    private final int userIdx;
    private final String email;
    private final String name;
}
