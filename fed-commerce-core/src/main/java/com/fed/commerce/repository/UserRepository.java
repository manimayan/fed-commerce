package com.fed.commerce.repository;


import com.fed.commerce.model.User;

import java.util.List;

public interface UserRepository {

    User checkLogin(User input);


}
