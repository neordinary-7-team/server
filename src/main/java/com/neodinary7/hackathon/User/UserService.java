package com.neodinary7.hackathon.User;

import com.neodinary7.hackathon.User.model.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public void addUser(UserRequest userRequest) {
        userDao.addUser(userRequest);
    }
}
