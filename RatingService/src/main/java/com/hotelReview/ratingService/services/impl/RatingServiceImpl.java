package com.hotelReview.ratingService.services.impl;

import com.hotelReview.ratingService.entities.Rating;
import com.hotelReview.ratingService.payloads.RatingAccessDTO;
import com.hotelReview.ratingService.repository.RatingRepo;
import com.hotelReview.ratingService.services.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService
{
    @Autowired
    private RatingRepo ratingRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public RatingAccessDTO createRatings(RatingAccessDTO ratingAccessDTO) {
         Rating rating=this.modelMapper.map(ratingAccessDTO,Rating.class);
            rating.setRatingId(UUID.randomUUID().toString());
        return   this.modelMapper.map(this.ratingRepo.save(rating),RatingAccessDTO.class);

    }

    @Override
    public List<RatingAccessDTO> getAllRatings() {
        List<Rating> ratings=this.ratingRepo.findAll();
        return ratings.stream().map(rate->this.modelMapper.map(rate,RatingAccessDTO.class)).collect(Collectors.toList());

    }

    @Override
    public List<RatingAccessDTO> getAllRatingByUserId(Integer uid) {

        List<Rating> ratings=this.ratingRepo.findByUserId(uid);
        return ratings.stream().map(rate->this.modelMapper.map(rate,RatingAccessDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<RatingAccessDTO> getAllRatingByHotelId(String hid) {
        List<Rating> ratings=this.ratingRepo.findByHotelId(hid);
        return ratings.stream().map(rate->this.modelMapper.map(rate,RatingAccessDTO.class)).collect(Collectors.toList());
    }
}
