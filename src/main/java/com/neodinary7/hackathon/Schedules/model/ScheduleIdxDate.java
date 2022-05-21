package com.neodinary7.hackathon.Schedules.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ScheduleIdxDate {
    private final int userIdx;
    private final String dateList;
}
