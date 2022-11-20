package com.hotelreview.user.service.repositories;

import com.hotelreview.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer>
{
    // Here we can write our customs Methods.
}
