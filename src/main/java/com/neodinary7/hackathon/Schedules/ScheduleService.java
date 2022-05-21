package com.neodinary7.hackathon.Schedules;

import com.neodinary7.hackathon.Schedules.model.ScheduleRequest;
import com.neodinary7.hackathon.config.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleDao scheduleDao;

    public void addSchedule(ScheduleRequest scheduleRequest) throws BaseException {
        scheduleDao.addSchedule(scheduleRequest);
    }
}
