package com.neodinary7.hackathon.Schedules;

import com.neodinary7.hackathon.Schedules.model.ScheduleDetail;
import com.neodinary7.hackathon.Schedules.model.ScheduleJoinRequest;
import com.neodinary7.hackathon.Schedules.model.ScheduleMemberDate;
import com.neodinary7.hackathon.Schedules.model.ScheduleRequest;
import com.neodinary7.hackathon.User.model.UserRequest;
import com.neodinary7.hackathon.config.BaseException;
import com.neodinary7.hackathon.config.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.neodinary7.hackathon.config.BaseResponseStatus.EXIST_USER_ERROR;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @ResponseBody
    @PostMapping //모임 생성
    public BaseResponse<Integer> addSchedule(@RequestBody ScheduleRequest scheduleRequest) {
        try {
            int idx = scheduleService.addSchedule(scheduleRequest);
            return new BaseResponse<>(idx);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("/join")
    public BaseResponse<String> joinSchedule(@RequestBody ScheduleJoinRequest scheduleJoinRequest) {
        try {
            scheduleService.joinSchedule(scheduleJoinRequest);
            String result = "success!";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PatchMapping("/join")
    public BaseResponse<String> modifySchedule(@RequestBody ScheduleJoinRequest scheduleJoinRequest) {
        try {
            scheduleService.modifySchedule(scheduleJoinRequest);
            String result = "success!";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/{scheduleIdx}")
    public BaseResponse<ScheduleDetail> getScheduleDetail(@PathVariable("scheduleIdx") int scheduleIdx) throws BaseException {
        try {
            return new BaseResponse<>(scheduleService.getScheduleDetail(scheduleIdx));
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/calender/{scheduleIdx}")
    public BaseResponse<List<ScheduleMemberDate>> getScheduleCalender(@PathVariable("scheduleIdx") int scheduleIdx) throws BaseException {
        try {
            List<ScheduleMemberDate> data = scheduleService.getScheduleCalender(scheduleIdx);
            return new BaseResponse<>(data);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
