package com.neodinary7.hackathon.Schedules.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Schedule {
    private final int scheduleIdx;
    private final String groupName;
    private final int userIdx;
    private final String dateList;
}
