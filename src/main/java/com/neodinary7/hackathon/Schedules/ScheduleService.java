package com.neodinary7.hackathon.Schedules;

import com.neodinary7.hackathon.Schedules.model.*;
import com.neodinary7.hackathon.config.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.neodinary7.hackathon.config.BaseResponseStatus.DATABASE_ERROR;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleDao scheduleDao;

    public int addSchedule(ScheduleRequest scheduleRequest) throws BaseException {
        try {
            return scheduleDao.addSchedule(scheduleRequest);
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

    public ScheduleDetail getScheduleDetail(int idx) throws BaseException {
        try {
            return scheduleDao.getScheduleDeatil(idx);
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public List<ScheduleMemberDate> getScheduleCalender(int idx) throws BaseException {
        try {
            return scheduleDao.getScheduleCalender(idx);
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public List<ScheduleJoinResponse> getJoinSchedule(int idx) throws BaseException {
        try {
            return scheduleDao.getJoinSchedule(idx);
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
