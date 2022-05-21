package com.neodinary7.hackathon.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends Throwable {
    private BaseResponseStatus status;
}
