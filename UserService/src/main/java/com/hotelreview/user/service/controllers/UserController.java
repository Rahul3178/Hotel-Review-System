package com.hotelreview.user.service.controllers;

import com.hotelreview.user.service.entities.User;
import com.hotelreview.user.service.exceptions.ResourceNotFoundException;
import com.hotelreview.user.service.payloads.ApiResponse;
import com.hotelreview.user.service.payloads.UserDTO;
import com.hotelreview.user.service.repositories.UserRepo;
import com.hotelreview.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO)
    {
        UserDTO createUser=this.userService.createUser(userDTO);

        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO,@PathVariable("userId") Integer userId) throws ResourceNotFoundException {
      UserDTO updatedUser= this.userService.updateUser(userDTO,userId);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) throws ResourceNotFoundException {
        this.userService.deleteUser(userId);
        return new  ResponseEntity<>(new ApiResponse("User Deleted Successfully", true),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers()
    {
        List<UserDTO> users=this.userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getSingleUser(@PathVariable("userId") Integer userId) throws ResourceNotFoundException {
        UserDTO user=this.userService.getSingleUser(userId);
        return ResponseEntity.ok(user);
    }

}
