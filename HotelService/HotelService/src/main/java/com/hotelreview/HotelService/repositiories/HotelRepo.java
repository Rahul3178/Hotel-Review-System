package com.hotelreview.HotelService.repositiories;

import com.hotelreview.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface HotelRepo  extends JpaRepository<Hotel,String>
{
    // we can write here additional methods for database
}
