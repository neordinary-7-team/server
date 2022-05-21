package com.neodinary7.hackathon.User;

import com.neodinary7.hackathon.User.model.LoginRequest;
import com.neodinary7.hackathon.User.model.LoginResponse;
import com.neodinary7.hackathon.User.model.UserRequest;
import com.neodinary7.hackathon.config.BaseException;
import com.neodinary7.hackathon.config.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.neodinary7.hackathon.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseBody
    @PostMapping("/signup") //회원가입
    public BaseResponse<String> singup(@RequestBody UserRequest userRequest) {
        try {
            if(userService.existUser(userRequest.getEmail()) != 0) {
                return new BaseResponse<>(EXIST_USER_ERROR);
            }
            userService.addUser(userRequest);
            String result = "success!";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/login") //로그인
    public BaseResponse<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            if(userService.existUser(loginRequest.getEmail()) == 0) {
                return new BaseResponse<>(NOT_EXIST_USER);
            }
            LoginResponse loginResponse = userService.getLogin(loginRequest);
            return new BaseResponse<>(loginResponse);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
