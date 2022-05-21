package com.neodinary7.hackathon.Concert;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ConcertController {
    private final ConcertCrawlingService concertCrawlingService;

    @GetMapping("/X")
    public String crawling() {

        try {
            //System.out.println("crawling controller");
            concertCrawlingService.getConcertData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    // (GET)
}
