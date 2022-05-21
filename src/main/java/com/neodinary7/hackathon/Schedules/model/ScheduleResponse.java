package com.neodinary7.hackathon.Schedules.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class ScheduleResponse {
    private final int userIdx;
    private final int scheduleIdx;
}