package com.neodinary7.hackathon.Schedules;

import com.neodinary7.hackathon.Schedules.model.ScheduleJoinRequest;
import com.neodinary7.hackathon.Schedules.model.ScheduleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ScheduleDao {
    private final JdbcTemplate jdbcTemplate;

    public void addSchedule(ScheduleRequest scheduleRequest) {
        String Query = "insert into Schedule(groupName, userIdx, startDate, endDate)\n" +
                "VALUES (?,?,?,?);";
        String startDate = scheduleRequest.getStartDate().toString();
        String endDate = scheduleRequest.getEndDate().toString();

        Object[] data = new Object[]{scheduleRequest.getGroupName(), scheduleRequest.getUserIdx(), startDate, endDate};
        this.jdbcTemplate.update(Query, data);
    }

    public void joinSchedule(ScheduleJoinRequest scheduleJoinRequest) {
        String strDateList = scheduleJoinRequest.getDateList().toString();
        String Query = "insert into UserJoinSchedule(scheduleIdx, userIdx, dateList) " +
                "values(?, ?, ?);";
        Object[] data = new Object[]{scheduleJoinRequest.getScheduleIdx(), scheduleJoinRequest.getUserIdx(), strDateList};
        this.jdbcTemplate.update(Query, data);
    }

    public void modifySchedule(ScheduleJoinRequest scheduleJoinRequest) {
        String strDateList = scheduleJoinRequest.getDateList().toString();
        String Query = "update UserJoinSchedule set dateList=? where scheduleIdx=? and userIdx=?;";
        Object[] data = new Object[]{strDateList, scheduleJoinRequest.getScheduleIdx(), scheduleJoinRequest.getUserIdx()};
        this.jdbcTemplate.update(Query, data);
    }
}
