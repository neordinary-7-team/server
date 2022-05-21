package com.neodinary7.hackathon.Schedules.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ScheduleRequest {
    private final String groupName;
    private final int userIdx;
    private final LocalDate startDate;
    private final LocalDate endDate;
}
