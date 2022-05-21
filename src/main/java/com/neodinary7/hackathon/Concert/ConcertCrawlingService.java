package com.neodinary7.hackathon.Concert;

import com.neodinary7.hackathon.Concert.Model.ConcertResponse;
import com.neodinary7.hackathon.config.BaseException;
import com.neodinary7.hackathon.config.BaseResponse;
import com.neodinary7.hackathon.config.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.neodinary7.hackathon.config.BaseResponseStatus.DATABASE_ERROR;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConcertCrawlingService {

    //private static ConcertDao concertDao;
    private final ConcertDao concertDao;

    public void insertConcertData() throws IOException {
        //System.out.println("crawling Service");
        log.info("service test");

        final String URL = "https://ticket.interpark.com/TPGoodsList.asp?Ca=Dra&Sort=2";
        Connection conn = Jsoup.connect(URL);
        Document doc = conn.get();
        int i = 1;
        Concert concert;

        Elements Rkdate = doc.getElementsByClass("Rkdate");
        String startDate = "", endDate = "";
        //int[] startDateAry = new int[10];
       // int[] endDateAry = new int[10];
        //LocalDate startLocalDate, endLocalDate;

        //System.out.println(concertDates.text());
        //System.out.println(concertEndDates.text());
        String[] concertDate = new String[20000];

        int cnt = 0;

        for (Element concertDates : Rkdate) {
            //System.out.println(concertName.text());
            //System.out.println(concertDate.text());
            Elements concertNames = doc.select("body > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div > div.con > div > table > tbody > tr:nth-child(" + i + ") > td.RKtxt > span > a");
            Elements concertLocations = doc.select("body > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div > div.con > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(3) > a");
            Elements concertImgs = doc.select("body > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div > div.con > div > table > tbody > tr:nth-child(" + i + ") > td.RKthumb > a > img");

            concertDate[cnt] = concertDates.text();
            if (concertDate[cnt].charAt(0) == '2') {
                startDate = concertDate[cnt].split("~ ")[0];
                endDate = concertDate[cnt].split("~ ")[1];

                //System.out.println("startDate : " + startDate);
                //System.out.println("endDate : " + endDate);
            }
/*
            System.out.println(concertNames.text());
            System.out.println(concertLocations.text());
            System.out.println(concertImgs.attr("src"));
            System.out.println(startDate);
            System.out.println(endDate);

            for (int j = 0; j < 3; j++) {
                startDateAry[j] = Integer.parseInt(startDate.split(".")[j]);
                endDateAry[j] = Integer.parseInt(endDate.split(".")[j]);
            }

            startLocalDate = LocalDate.of(startDateAry[0], startDateAry[1], startDateAry[2]);
            endLocalDate = LocalDate.of(endDateAry[0], endDateAry[1], endDateAry[2]);
*/
            concert = new Concert(concertNames.text(), concertLocations.text(), concertImgs.attr("src"), startDate, endDate);
            concertDao.insertConcertData(concert);
            cnt++;
            i++;
        }


    }

    public List<ConcertResponse> getConcertData(String date) throws BaseException {
        try {
            System.out.println("Service getConcertData()");
            List<ConcertResponse> concertResponses = concertDao.selectConcert(date);

            return concertResponses;
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
