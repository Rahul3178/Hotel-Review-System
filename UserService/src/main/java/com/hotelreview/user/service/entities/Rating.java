package com.hotelreview.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating
{
   private String ratingId;
   private Integer userId;
   private String  feedBack;
   private  String hotelId;
   private int rating;


}
