package com.hotelreview.user.service.services.impl;

import com.hotelreview.user.service.entities.User;
import com.hotelreview.user.service.exceptions.ResourceNotFoundException;
import com.hotelreview.user.service.payloads.UserDTO;
import com.hotelreview.user.service.repositories.UserRepo;
import com.hotelreview.user.service.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
