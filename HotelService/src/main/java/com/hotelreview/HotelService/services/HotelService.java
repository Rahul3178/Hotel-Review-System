package com.hotelreview.HotelService.services;

import com.hotelreview.HotelService.payloads.HotelDTO;

import java.util.List;

public interface HotelService
{
    HotelDTO createHotel(HotelDTO hotelDTO);

    List<HotelDTO> getHotels();

    HotelDTO getSingleHotel(String id);
}
