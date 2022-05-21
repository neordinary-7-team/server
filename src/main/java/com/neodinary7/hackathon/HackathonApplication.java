package com.neodinary7.hackathon;

import Concert.ConcertCrawlingService;
import Concert.ConcertDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;


@SpringBootApplication
public class HackathonApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(HackathonApplication.class, args);
//		ConcertCrawlingService concertCrawling = new ConcertCrawlingService(new ConcertDao());
//
//		concertCrawling.getConcertData();

	}

}
