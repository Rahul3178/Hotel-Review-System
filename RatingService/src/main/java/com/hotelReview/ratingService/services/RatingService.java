package com.hotelReview.ratingService.services;

import com.hotelReview.ratingService.payloads.RatingAccessDTO;

import java.util.List;

public interface RatingService
{

        RatingAccessDTO createRatings(RatingAccessDTO ratingAccessDTO);
        List<RatingAccessDTO> getAllRatings();
    // get all rating by userId
        List<RatingAccessDTO> getAllRatingByUserId(Integer uid);
    // get all ratings by hotelId

        List<RatingAccessDTO> getAllRatingByHotelId(String hid);
}
