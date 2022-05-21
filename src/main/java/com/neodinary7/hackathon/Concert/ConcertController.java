package com.neodinary7.hackathon.Concert;

import com.neodinary7.hackathon.Concert.Model.ConcertResponse;
import com.neodinary7.hackathon.config.BaseException;
import com.neodinary7.hackathon.config.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ConcertController {
    private final ConcertCrawlingService concertCrawlingService;


//    public ConcertController(ConcertCrawlingService concertCrawlingService) {
//        this.concertCrawlingService = concertCrawlingService;
//    }

    @GetMapping("/crawling/x")
    public String crawling() {

        try {
            //System.out.println("crawling controller");
            concertCrawlingService.insertConcertData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    // (GET) /concert?date={scheduleDate}
    @ResponseBody
    @GetMapping("/concert")
    public BaseResponse<List<ConcertResponse>> getConcertData(@RequestParam String date) {
        try {
            List<ConcertResponse> Concerts = concertCrawlingService.getConcertData(date);
            return new BaseResponse<>(Concerts);
        } catch (BaseException e) {
            return new BaseResponse<> (e.getStatus());
        }

    }
}
