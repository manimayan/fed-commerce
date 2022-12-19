package com.fed.commerce.service.impl;

import com.fed.commerce.model.User;
import com.fed.commerce.repository.UserRepository;
import com.fed.commerce.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User checkLogin(User input) {

        User user = repository.checkLogin(input);
        if (null != user) {
            log.info("fetched data for Id: {} successfully", input.getUserId());
        } else {
            log.info("fetching failed");
        }
        return user;
    }

}
