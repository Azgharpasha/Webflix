package com.MovieMania.Wishlist.repo;

import com.MovieMania.Wishlist.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
    public WishList findByEmailId(String emailId);
}
