package com.neodinary7.hackathon.Schedules;

import com.neodinary7.hackathon.Schedules.model.ScheduleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ScheduleDao {
    private final JdbcTemplate jdbcTemplate;

    public void addSchedule(ScheduleRequest scheduleRequest) {
        String Query = "insert into schedule(groupName, userIdx, startDate, endDate)\n" +
                "VALUES (?,?,?,?);";
        String startDate = scheduleRequest.getStartDate().toString();
        String endDate = scheduleRequest.getEndDate().toString();

        Object[] data = new Object[]{scheduleRequest.getGroupName(), scheduleRequest.getUserIdx(), startDate, endDate};
        this.jdbcTemplate.update(Query, data);
    }
}
