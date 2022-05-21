package com.neodinary7.hackathon.Schedules.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleJoinResponse {
    private final int userIdx;
    private final int scheduleIdx;
    private final String groupName;
}
