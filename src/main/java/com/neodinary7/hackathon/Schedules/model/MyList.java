package com.neodinary7.hackathon.Schedules.model;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MyList {
    private final int userIdx;
    private final String name;
    private final String email;
    private final String password;
}