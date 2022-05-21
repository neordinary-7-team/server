package com.neodinary7.hackathon.Concert;

import com.neodinary7.hackathon.Concert.Model.ConcertResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ConcertDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public ConcertDao(DataSource dataSource) {
       jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertConcertData(Concert concert) {
        //System.out.println("crawling Dao");

        String Query = "insert into hackaton7.Concert(name, location, image, startDate, endDate, url) values (?,?,?,?,?,?);";
        Object[] concertData = new Object[]{concert.getName(), concert.getLocation(), concert.getImg(), concert.getStartDate(), concert.getEndDate(), "http://ticket.interpark.com/TPGoodsList.asp?Ca=Dra&Sort=2"};
        this.jdbcTemplate.update(Query, concertData);
    }

    public List<ConcertResponse> selectConcert(String date) {
        System.out.println("Dao selectConcert");
        String Query = "select concertIdx, name, location, image, startDate, endDate from hackaton7.Concert where startDate <= ? and endDate >= ?";

        return this.jdbcTemplate.query(Query, concertRowMapper(), date, date);

    }

    private RowMapper<ConcertResponse> concertRowMapper() {
        return (rs, rowNum) ->{
            ConcertResponse concertResponse = new ConcertResponse();

            concertResponse.setConcertIdx(rs.getInt("concertIdx"));
            concertResponse.setName(rs.getString("name"));
            concertResponse.setLocation(rs.getString("location"));
            concertResponse.setImg(rs.getString("image"));
            concertResponse.setStartDate(rs.getString("startDate"));
            concertResponse.setEndDate(rs.getString("endDate"));

            return concertResponse;
        };
    }


}
