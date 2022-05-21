package com.neodinary7.hackathon.Schedules;

import com.neodinary7.hackathon.Schedules.model.*;
import com.neodinary7.hackathon.User.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ScheduleDao {
    private final JdbcTemplate jdbcTemplate;

    public int addSchedule(ScheduleRequest scheduleRequest) {
        String Query = "insert into Schedule(groupName, userIdx, dateList)\n" +
                "VALUES (?,?,?);";
        String strDate = scheduleRequest.getDateList().toString();

        Object[] data = new Object[]{scheduleRequest.getGroupName(), scheduleRequest.getUserIdx(), strDate};
        this.jdbcTemplate.update(Query, data);
        Query = "SELECT last_insert_id();";

        return this.jdbcTemplate.queryForObject(Query, Integer.class);
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

    public ScheduleDetail getScheduleDeatil(int idx) {
        String Query = "select scheduleIdx, groupName, userIdx, dateList from Schedule where scheduleIdx=?";

        Schedule schedule = this.jdbcTemplate.queryForObject(Query,
                (rs,rowNum) -> new Schedule(
                        rs.getInt("scheduleIdx"),
                        rs.getString("groupName"),
                        rs.getInt("userIdx"),
                        rs.getString("dateList")), idx);

        String str = schedule.getDateList().substring(1, schedule.getDateList().length()-1);
        List<String> dates = List.of(str.split(","));

        Query = "select userIdx from UserJoinSchedule where scheduleIdx = ?";
        List<Integer> membersIdx = this.jdbcTemplate.query(Query,
                (rs, rowNum) -> rs.getInt("userIdx"), idx);
        log.info("members : {}", membersIdx);
        List<String> members = new ArrayList<>();
        Query = "select name from User where userIdx=?";

        for(Integer member : membersIdx) {
            String name = this.jdbcTemplate.queryForObject(Query, (rs, rowNum) -> rs.getString("name"), member);
            members.add(name);
        }

        return new ScheduleDetail(schedule.getScheduleIdx(), schedule.getGroupName(),
                schedule.getUserIdx(), members, dates);
    }

    public List<ScheduleMemberDate> getScheduleCalender(int idx) {
        String Query = "select userIdx, dateList from UserJoinSchedule where scheduleIdx = ?;";
        List<ScheduleIdxDate> date = this.jdbcTemplate.query(Query,
                (rs,rowNum) -> new ScheduleIdxDate(
                        rs.getInt("userIdx"),
                        rs.getString("dateList")), idx);
        List<ScheduleMemberDate> arr = new ArrayList<>();
        Query = "select name from User where userIdx=?";
        for(ScheduleIdxDate s : date) {
            String name = this.jdbcTemplate.queryForObject(Query, (rs, rowNum) -> rs.getString("name"), s.getUserIdx());
            String str = s.getDateList().substring(1, s.getDateList().length()-1);
            List<String> dates = List.of(str.split(","));
            List<String> dd = new ArrayList<>();
            for(int i=0;i<dates.size();i++) {
                dd.add(dates.get(i).trim());
            }
            arr.add(new ScheduleMemberDate(name, dd));
        }
        return arr;
    }
}
