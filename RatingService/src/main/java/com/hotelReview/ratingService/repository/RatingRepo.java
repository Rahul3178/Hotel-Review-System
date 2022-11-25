package com.hotelReview.ratingService.repository;

import com.hotelReview.ratingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating,String> {
}
