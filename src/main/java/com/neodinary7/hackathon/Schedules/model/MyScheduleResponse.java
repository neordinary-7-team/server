package com.neodinary7.hackathon.Schedules.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class MyScheduleResponse {

    private final int scheduleIdx;
    private final String groupName;
    private final int userIdx;
    private final List<String> dates;
}
