package com.hotelreview.user.service.services;

import com.hotelreview.user.service.entities.User;
import com.hotelreview.user.service.exceptions.ResourceNotFoundException;
import com.hotelreview.user.service.payloads.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService  {

    // here we will declare all method
    UserDTO createUser(UserDTO user);
    void deleteUser(Integer uid) throws ResourceNotFoundException;

    UserDTO updateUser(UserDTO user, Integer uid) throws ResourceNotFoundException;

    List<UserDTO> getAllUsers();
    UserDTO getSingleUser(Integer id) throws ResourceNotFoundException;
}
