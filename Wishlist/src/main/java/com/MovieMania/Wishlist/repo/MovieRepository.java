package com.MovieMania.Wishlist.repo;

import com.MovieMania.Wishlist.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movies,String> {



    @Query("select  a from Movies a where a.user.userId = :userId")
    public Optional<List<Movies>> findByUserId(@Param("userId") int userId);

    @Modifying
    @Query("DELETE from Movies a where a.user.userId = :userId")
    public void deleteAllByUserId(@Param("userId") int userId);

    @Modifying
    @Query("DELETE from Movies a where a.id = :id")
    public void deleteMovieByMovieId(String id);

    @Modifying
    @Query("delete from Movies a where a.id = :getMovieId and a.user.userId = :getUserId")
    public void deleteByMovieIdAndUserId(@Param("getMovieId") String getMovieId, @Param("getUserId") int getUserId);
}
