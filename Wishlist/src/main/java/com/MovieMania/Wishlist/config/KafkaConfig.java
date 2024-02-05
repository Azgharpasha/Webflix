package com.MovieMania.Wishlist.config;

import com.MovieMania.Wishlist.model.FullUser;
import com.MovieMania.Wishlist.model.WishList;
import com.MovieMania.Wishlist.repo.WishListRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;



@Configuration
public class KafkaConfig {

    @Autowired
    WishListRepository wishListRepository;


    /*
    Provide KafkaListener config annotation
     */
    @KafkaListener(topics = "wishlist", groupId = "wishlist")
    public void updatedLocation(String value) throws JsonProcessingException {
        System.out.println(value);

        ObjectMapper objectMapper = new ObjectMapper();
        FullUser fullUser = objectMapper.readValue(value, FullUser.class);

        WishList user = new WishList();
        user.setEmailId(fullUser.getEmailId());


        System.out.println(fullUser.getEmailId());


        wishListRepository.save(user);

        System.out.println(user.getUserId());
        System.out.println(user.getEmailId());

    }

}
