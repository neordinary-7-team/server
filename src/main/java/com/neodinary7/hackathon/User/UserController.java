package com.neodinary7.hackathon.User;

import com.neodinary7.hackathon.User.model.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup") //회원가입
    public String singup(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
        return "success";
    }
}
