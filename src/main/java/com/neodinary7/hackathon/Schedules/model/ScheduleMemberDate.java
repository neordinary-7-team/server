package com.neodinary7.hackathon.Schedules.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ScheduleMemberDate {
    private final String name;
    private final List<String> dateList;
}
