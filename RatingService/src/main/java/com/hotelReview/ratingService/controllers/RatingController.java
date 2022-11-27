package com.hotelReview.ratingService.controllers;

import com.hotelReview.ratingService.payloads.RatingAccessDTO;
import com.hotelReview.ratingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController
{
    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<RatingAccessDTO> createRatings(@RequestBody RatingAccessDTO ratingAccessDTO)
    {
        return new ResponseEntity<>(this.ratingService.createRatings(ratingAccessDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<RatingAccessDTO>> getALLRatings()
    {
      List<RatingAccessDTO> ratingAccessDTOS=this.ratingService.getAllRatings();
      return ResponseEntity.status(HttpStatus.FOUND).body(ratingAccessDTOS);
    }

    @GetMapping("/users/{uid}")
    public ResponseEntity<List<RatingAccessDTO>> getALLRatingsByUserId(@PathVariable Integer uid)
    {
      List<RatingAccessDTO> ratingAccessDTOS=this.ratingService.getAllRatingByUserId(uid);
      return ResponseEntity.status(HttpStatus.FOUND).body(ratingAccessDTOS);
    }

    @GetMapping("/hotels/{hid}")
    public ResponseEntity<List<RatingAccessDTO>> getALLRatingsByHotelId(@PathVariable String hid)
    {
      List<RatingAccessDTO> ratingAccessDTOS=this.ratingService.getAllRatingByHotelId(hid);
      return ResponseEntity.status(HttpStatus.FOUND).body(ratingAccessDTOS);
    }


}
