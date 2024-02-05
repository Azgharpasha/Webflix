package com.cts.newsnest.authservice.kafka;


import com.cts.newsnest.authservice.domain.User;
import com.cts.newsnest.authservice.domain.UserDetails;
import com.cts.newsnest.authservice.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Configuration
public class KafkaConfig {

    @Autowired
    UserRepository userRepository;


    @KafkaListener(topics = "movie", groupId = "authgroup")
    public void updatedLocation(String value) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        UserDetails fullUser = objectMapper.readValue(value, UserDetails.class);
        System.out.println(value);

        User user = new User(fullUser.getEmailId(),fullUser.getPassword());

        System.out.println(user);
        userRepository.save(user);

    }

}
