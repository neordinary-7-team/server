package com.neodinary7.hackathon.User;

import com.neodinary7.hackathon.User.model.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public void addUser(UserRequest userRequest) {
        log.info("userRequest : {}", userRequest);

        String Query = "insert into User(name, email, password) values (?,?,?);";
        Object[] userData = new Object[]{userRequest.getName(), userRequest.getEmail(), userRequest.getPassword()};
        this.jdbcTemplate.update(Query, userData);
    }
}
