package com.neodinary7.hackathon.Schedules.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ScheduleDetail {
    private final int scheduleIdx;
    private final String groupName;
    private final int userIdx; //모임장
    private final List<String> members; //모임 참가 인원 이름
    private final List<String> dates; //모임 날짜 리스트
}
