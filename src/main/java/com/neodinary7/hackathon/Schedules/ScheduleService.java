package com.neodinary7.hackathon.Schedules;

import com.neodinary7.hackathon.Schedules.model.ScheduleJoinRequest;
import com.neodinary7.hackathon.Schedules.model.ScheduleRequest;
import com.neodinary7.hackathon.config.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.neodinary7.hackathon.config.BaseResponseStatus.DATABASE_ERROR;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleDao scheduleDao;

    public void addSchedule(ScheduleRequest scheduleRequest) throws BaseException {
        try {
            scheduleDao.addSchedule(scheduleRequest);
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public void joinSchedule(ScheduleJoinRequest scheduleJoinRequest) throws BaseException {
        try {
            scheduleDao.joinSchedule(scheduleJoinRequest);
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public void modifySchedule(ScheduleJoinRequest scheduleJoinRequest) throws BaseException {
        try {
            scheduleDao.modifySchedule(scheduleJoinRequest);
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
