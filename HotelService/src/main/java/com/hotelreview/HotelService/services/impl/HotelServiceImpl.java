package com.hotelreview.HotelService.services.impl;

import com.hotelreview.HotelService.entities.Hotel;
import com.hotelreview.HotelService.exceptions.ResourceNotFoundException;
import com.hotelreview.HotelService.payloads.HotelDTO;
import com.hotelreview.HotelService.repositiories.HotelRepo;
import com.hotelreview.HotelService.services.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService
{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private HotelRepo hotelRepo;
    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO)
    {


      Hotel hotel=  this.modelMapper.map(hotelDTO,Hotel.class);
        String id=UUID.randomUUID().toString();
        hotel.setHotelId(id);
     return this.modelMapper.map(this.hotelRepo.save(hotel),HotelDTO.class);

    }

    @Override
    public List<HotelDTO> getHotels() {
        List<Hotel> hotels=this.hotelRepo.findAll();
        List<HotelDTO> hotelDTOS=hotels.stream().map(hotel->this.modelMapper.map(hotel,HotelDTO.class)).collect(Collectors.toList());
        return hotelDTOS;
    }

    @Override
    public HotelDTO getSingleHotel(String id) {
     Hotel hotel= this.hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel","hotel_id",id));

        return this.modelMapper.map(hotel,HotelDTO.class);
    }


}
