package com.neodinary7.hackathon.config;

import lombok.Getter;

/**
 * [ 1000단위 ]
 *  1000 : 요청 성공
 *  2 : Request 오류
 *  3 : Reponse 오류
 *  4 : DB, Server 오류
 *
 * [ 100단위 ]
 *  0 : 공통 오류
 *  1 : users 오류
 *  2 : walks 오류
 *  3 : notice 오류
 *  4 : schedule 오류
 *
 * [10단위]
 *  0~19 : Common
 *  20~39 : GET
 *  40~59 : POST
 *  60~79 : PATCH
 *  80~99 : else
 */

@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    /**
     * 2000 : Request 오류
     */

    WRONG_PASSWORD(false, 2004, "잘못된 비밀번호입니다."),
    INVALID_USERIDX(false,2100,"잘못된 유저 인덱스입니다."),
    NOT_EXIST_USER(false, 2101, "존재하지 않는 유저입니다."),
    INVALID_SCHEDULE(false,2104,"스케줄이 존재하지 않습니다."),
    POST_USERS_EMPTY_EMAIL(false, 2148, "이메일을 입력해주세요."),
    POST_USERS_INVALID_EMAIL(false, 2149, "이메일 형식을 확인해주세요."),
    POST_USERS_EMPTY_USERID(false, 2150, "유저 ID를 입력해주세요."),
    MAX_NICKNAME_LENGTH(false, 2160, "닉네임은 8자를 초과할 수 없습니다."),
    INVALID_BIRTH(false, 2161, "생년월일 값은 0000-00-00이 될 수 없습니다."),
    INVALID_NOTICE_IDX(false,2320,"잘못된 인덱스입니다."),
    EXIST_USER_ERROR(false, 2400, "이미 존재하는 유저입니다."),

    /**
     * 3000 : Response 오류
     */

    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다."),
    S3UPLOAD_ERROR(false, 4080, "파일 업로드에 실패하였습니다."),
    MODIFY_USERINFO_FAIL(false,4161,"유저 정보 변경에 실패하였습니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;
    private int userIdx;
    private String scheduleIdx;
    private String dateList;
    private BaseResponseStatus(boolean isSuccess, int code, String message) { //BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
    private BaseResponseStatus(boolean isSuccess, int code, String message,int userIdx,String scheduleIdx,String dateList) { //BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.userIdx = userIdx;
        this.scheduleIdx = scheduleIdx;
        this.dateList=dateList;
    }

}
