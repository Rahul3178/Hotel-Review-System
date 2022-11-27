package com.hotelReview.ratingService.repository;

import com.hotelReview.ratingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,String>
{
    //customer finder methods
    List<Rating> findByUserId(Integer userId);
    List<Rating> findByHotelId(String hotelId);
}
