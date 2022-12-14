package com.hotelReview.ratingService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "micro_rating")
public class Rating
{
    @Id
    private String ratingId;
    private Integer userId;
    private String  feedBack;
    private  String hotelId;
    private int rating;

}
