package com.neodinary7.hackathon.User;

import com.neodinary7.hackathon.User.model.LoginRequest;
import com.neodinary7.hackathon.User.model.LoginResponse;
import com.neodinary7.hackathon.User.model.User;
import com.neodinary7.hackathon.User.model.UserRequest;
import com.neodinary7.hackathon.config.BaseException;
import com.neodinary7.hackathon.config.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.neodinary7.hackathon.config.BaseResponseStatus.DATABASE_ERROR;
import static com.neodinary7.hackathon.config.BaseResponseStatus.WRONG_PASSWORD;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public void addUser(UserRequest userRequest) throws BaseException {
        try {
            userDao.addUser(userRequest);
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public int existUser(String email) throws BaseException {
        try {
            return userDao.existUser(email);
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public LoginResponse getLogin(LoginRequest loginRequest) throws BaseException {
        try {
            User user = userDao.getUser(loginRequest.getEmail());
            if(!user.getPassword().equals(loginRequest.getPassword())) {
                throw new BaseException(WRONG_PASSWORD);
            }
            return new LoginResponse(user.getUserIdx(), user.getEmail(), user.getName());

        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
