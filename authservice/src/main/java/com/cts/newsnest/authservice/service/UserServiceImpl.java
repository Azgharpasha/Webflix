package com.cts.newsnest.authservice.service;

import com.cts.newsnest.authservice.domain.User;
import com.cts.newsnest.authservice.exception.UserAlreadyExistException;
import com.cts.newsnest.authservice.exception.UserNotFoundException;
import com.cts.newsnest.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 * This class is implementing the UserService interface. This class has to be annotated with
 * @Service annotation.
 * @Service indicates annotated class is a service
 * which hold business logic in the Service layer
 *
 * */

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    /**
     * To get the property values
     */
    @Value("${app.service.message1}")
    private String message1;

    @Value("${app.service.message2}")
    private String message2;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    public User findByIdAndPassword(String id, String password) throws UserNotFoundException {
        User authUser = userRepository.findByIdAndPassword(id, password);
        if (authUser == null) {
            throw new UserNotFoundException(message2);
        }
        return authUser;
    }

}
