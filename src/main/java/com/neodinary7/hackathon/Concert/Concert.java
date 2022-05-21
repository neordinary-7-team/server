package com.neodinary7.hackathon.Concert;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class Concert {

    private int concertIdx;
    private String name;
    private String location;
    private String url;
    private String img;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String startDate;
    private String endDate;

    public Concert(String name, String location, String img, String startDate, String endDate) {
        this.name = name;
        this.location = location;
        //this.url = url;
        this.img = img;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
