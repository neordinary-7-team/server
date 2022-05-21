package com.neodinary7.hackathon.User;

import com.neodinary7.hackathon.User.model.LoginRequest;
import com.neodinary7.hackathon.User.model.LoginResponse;
import com.neodinary7.hackathon.User.model.User;
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
        String Query = "insert into User(name, email, password) values (?,?,?);";
        Object[] userData = new Object[]{userRequest.getName(), userRequest.getEmail(), userRequest.getPassword()};
        this.jdbcTemplate.update(Query, userData);
    }

    public int existUser(String email) {
        String Query = "select exists(select userIdx from User where email = ?) as success;";
        int id = 0;
        id = this.jdbcTemplate.queryForObject(Query, Integer.class, email);
        return id;
    }

    public User getUser(String email) {
        String Query = "select * from User where email = ?";
        return this.jdbcTemplate.queryForObject(Query,
                (rs,rowNum) -> new User(
                        rs.getInt("userIdx"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")), email);
    }
}
