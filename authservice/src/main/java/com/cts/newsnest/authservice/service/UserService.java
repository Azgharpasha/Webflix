package com.cts.newsnest.authservice.service;

import com.cts.newsnest.authservice.domain.User;
import com.cts.newsnest.authservice.exception.UserAlreadyExistException;
import com.cts.newsnest.authservice.exception.UserNotFoundException;

public interface UserService {

    User findByIdAndPassword(String emailId, String password) throws UserNotFoundException;
}
