package com.neodinary7.hackathon.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.neodinary7.hackathon.config.BaseResponseStatus.SUCCESS;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess","a", "code", "message","result"})
public class BaseScheduleResponse<T> {
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private String message;
    private int code;
    private int userIdx;
    private String scheduleIdx;
    private String dateList;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;


    // 기본 요청에 성공한 경우
    public BaseScheduleResponse(T result) {
        this.isSuccess = SUCCESS.isSuccess();
        this.userIdx = SUCCESS.getUserIdx();
        this.scheduleIdx = SUCCESS.getScheduleIdx();
        this.dateList = SUCCESS.getDateList();
        this.message = SUCCESS.getMessage();
        this.code = SUCCESS.getCode();
        this.result = result;
    }

    // 기본 요청에 실패한 경우
    public BaseScheduleResponse(BaseResponseStatus status) {
        this.isSuccess = status.isSuccess();
        this.userIdx= status.getUserIdx();
        this.message = status.getMessage();
        this.code = status.getCode();
    }

}
