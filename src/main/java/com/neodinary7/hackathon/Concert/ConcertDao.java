package com.neodinary7.hackathon.Concert;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConcertDao {

    public final JdbcTemplate jdbcTemplate;

//    public ConcertDao(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    public void insertConcertData(Concert concert) {
        //System.out.println("crawling Dao");

        String Query = "insert into hackaton7.Concert(name, location, image, startDate, endDate, url) values (?,?,?,?,?,?);";
        Object[] concertData = new Object[]{concert.getName(), concert.getLocation(), concert.getImg(), concert.getStartDate(), concert.getEndDate(), "http://ticket.interpark.com/TPGoodsList.asp?Ca=Dra&Sort=2"};
        this.jdbcTemplate.update(Query, concertData);
    }
}
