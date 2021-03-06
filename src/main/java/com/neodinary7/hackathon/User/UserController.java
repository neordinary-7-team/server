package com.neodinary7.hackathon.User;

import com.neodinary7.hackathon.Schedules.model.IdxResponse;
import com.neodinary7.hackathon.Schedules.model.ScheduleResponse;
import com.neodinary7.hackathon.User.model.LoginRequest;
import com.neodinary7.hackathon.User.model.LoginResponse;
import com.neodinary7.hackathon.User.model.UserRequest;
import com.neodinary7.hackathon.config.BaseException;
import com.neodinary7.hackathon.config.BaseResponse;
import com.neodinary7.hackathon.config.BaseScheduleResponse;
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

    @PostMapping("/login") //로그인
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
    /*
     * 일정 테이블
     * 일정을 만들었고 useridx
     * 내가 조회하는 Userjoin idx
     *
     * */
    @GetMapping("/listcheck")
    public BaseScheduleResponse<ScheduleResponse> listcheck(@RequestParam("idx") String idx) {
        try {
            if(idx.length()==0) {
                return new BaseScheduleResponse<>(NOT_EXIST_USER);
            }
            else {
                IdxResponse idxresponse = userService.existsidx(idx);
                if (idxresponse.getIdx()==0) {
                    return new BaseScheduleResponse<>(INVALID_SCHEDULE);
                }
                // private final int userIdx;
                //    private final String scheduleIdx;
                //    private final String dateList;

                ScheduleResponse scheduleResponse = userService.myScheduleList(idx);
                return new BaseScheduleResponse<>(scheduleResponse);
            }
        } catch (BaseException exception) {
            return new BaseScheduleResponse<>(exception.getStatus());
        }
    }
}
