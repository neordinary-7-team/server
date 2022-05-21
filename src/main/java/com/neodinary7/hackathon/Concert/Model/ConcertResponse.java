package com.neodinary7.hackathon.Concert.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ConcertResponse {
    private int concertIdx;
    private String name;
    private String location;
    private String img;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String endDate;

}
