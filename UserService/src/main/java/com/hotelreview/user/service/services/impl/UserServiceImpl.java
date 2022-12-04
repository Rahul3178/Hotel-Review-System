package com.hotelreview.user.service.services.impl;

import com.hotelreview.user.service.entities.Hotel;
import com.hotelreview.user.service.entities.Rating;
import com.hotelreview.user.service.entities.User;
import com.hotelreview.user.service.exceptions.ResourceNotFoundException;
import com.hotelreview.user.service.payloads.UserDTO;
import com.hotelreview.user.service.repositories.UserRepo;
import com.hotelreview.user.service.services.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{
    //here also we auto wire repository object
    @Autowired
    private UserRepo userRepo;
    // Here we also auto-wire ModelMapper object
    @Autowired
    private ModelMapper modelMapper;
    // here we will implement all methods of user interface

    @Autowired
    private RestTemplate restTemplate; // for api calling

    @Autowired
    private Logger logger;

    @Override
    public UserDTO createUser(UserDTO userDTO)
    {
     User user=   userDTOToUser(userDTO);
        User savedUser=this.userRepo.save(user);
        return this.userToUserDTO(savedUser);
    }


    @Override
    public void deleteUser(Integer userId) throws ResourceNotFoundException {
        User deleteUser=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        this.userRepo.delete(deleteUser);
    }


    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer uid) throws ResourceNotFoundException {
      User updateUser =this.userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("UserDTO","uid",uid));
        updateUser.setUserName(userDTO.getUserName());
        updateUser.setUserEmail(userDTO.getUserEmail());
        updateUser.setAboutUser(userDTO.getAboutUser());
      User updated= this.userRepo.save(updateUser);
      return this.userToUserDTO(updated);
    }


    @Override
    public List<UserDTO> getAllUsers() {
       List<User> users=this.userRepo.findAll();
     List<UserDTO> DTOUsers= users.stream().map(user->this.userToUserDTO(user)).collect(Collectors.toList());

        return DTOUsers;
    }


    @Override
    public UserDTO getSingleUser(Integer uid) throws ResourceNotFoundException {
        User fuser=this.userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","user_Id",uid));
        // fetch rating of above user from rating service
        // we have to call rating service using api
        //http://localhost:8083/ratings/users/9
        //calling http client with the help of Http api-> using rest template

    Rating[] ratingsOfUser=   restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+fuser.getUserId(), Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();


        logger.info("fetch Ratings"+ratingsOfUser);
       List<Rating> allRatings=ratings.stream().map(rating -> {
           // calling hotel service to get Hotel
         ResponseEntity<Hotel> hotels =  restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
          Hotel hotel= hotels.getBody();
           // set Hotel Ratings
            logger.info("Response status code: {}"+ hotels.getStatusCode());
           rating.setHotel(hotel);
           //return ratings;
           return rating;
        }).collect(Collectors.toList());
        fuser.setRatings(allRatings);
        return this.userToUserDTO(fuser);
    }

    /*Here we will try to use Model Mapper to mapp data b/w User and userDto object*/

    public UserDTO userToUserDTO(User user)
    {
        return this.modelMapper.map(user, UserDTO.class);
    }

    public User userDTOToUser(UserDTO userDTO)
    {
        return this.modelMapper.map(userDTO,User.class);
    }
}
