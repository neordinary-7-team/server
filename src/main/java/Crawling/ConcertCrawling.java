package Crawling;

import Concert.Concert;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.desktop.ScreenSleepEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;


public class ConcertCrawling {

    public ConcertCrawling() {

    }

    public static void getConcertData() throws IOException {
        final String URL = "https://ticket.interpark.com/TPGoodsList.asp?Ca=Dra&Sort=2";
        Connection conn = Jsoup.connect(URL);
        Document doc = conn.get();
        int i = 1;
        Concert concert;

        Elements concertNames = doc.getElementsByClass("fw_bold");
        Elements concertLocations = doc.select("body > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div > div.con > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(3) > a");
        Elements concertImgs = doc.select("body > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div > div.con > div > table > tbody > tr:nth-child(" + i + ") > td.RKtxt > img");
        Elements Rkdate = doc.getElementsByClass("Rkdate");
        String startDate = "", endDate = "";

        //System.out.println(concertDates.text());
        //System.out.println(concertEndDates.text());
        String[] concertDate = new String[20000];

        int cnt = 0;

        for (Element concertDates : Rkdate) {
            //System.out.println(concertName.text());
            //System.out.println(concertDate.text());

            concertDate[cnt] = concertDates.text();
            if (concertDate[cnt].charAt(0) == '2') {
                startDate = concertDate[cnt].split("~ ")[0];
                endDate = concertDate[cnt].split("~ ")[1];

                //System.out.println("startDate : " + startDate);
                //System.out.println("endDate : " + endDate);
            }
            else {

            }
            cnt++;

            System.out.println(concertNames.text());
            System.out.println(concertLocations.text());
            System.out.println(concertImgs.attr("src"));
            System.out.println(startDate);
            System.out.println(endDate);


            concert = new Concert(concertNames.text(), concertLocations.text(), concertImgs.attr("src"), LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE), LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE));

        }


    }






}
