package com.hotelReview.ratingService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Rating
{
    @Id
    private String ratingId;
    private Integer userId;
    private String  feedBack;
    private  String hotelId;
    private int rating;

}
