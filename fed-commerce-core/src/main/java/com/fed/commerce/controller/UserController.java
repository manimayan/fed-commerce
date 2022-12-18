package com.fed.commerce.controller;


import com.fed.commerce.model.User;
import com.fed.commerce.model.UserDto;
import com.fed.commerce.service.OrderService;
import com.fed.commerce.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
	UserService service;

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> login(@RequestBody UserDto input) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		User data = null;
		if (input.checkLoginFields()) {
			data = new User(input);
			try {
				data = service.checkLogin(data);
				status = HttpStatus.OK;
			} catch (Exception e) {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
				log.error("Error in processing", e);
			}
		}
		return new ResponseEntity<>(data, status);
	}
}
