package Concert;

import Concert.Concert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
@RequiredArgsConstructor
public class ConcertDao {

    public final JdbcTemplate jdbcTemplate;

//    public ConcertDao(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    public void insertConcertData(Concert concert) {
        System.out.println("crawling Dao");

        String Query = "insert into hackaton7.Concert(name, location, image, startDate, endDate) values (?,?,?);";
        Object[] concertData = new Object[]{concert.getName(), concert.getLocation(), concert.getImg(), concert.getStartDate(), concert.getEndDate()};
        this.jdbcTemplate.update(Query, concertData);
    }
}
