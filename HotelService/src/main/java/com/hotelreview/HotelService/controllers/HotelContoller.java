package com.hotelreview.HotelService.controllers;

import com.hotelreview.HotelService.payloads.HotelDTO;
import com.hotelreview.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelContoller
{
    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO)
    {
        HotelDTO hotelDTO1=this.hotelService.createHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO1,HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<HotelDTO>> getHotels()
    {
        return ResponseEntity.ok(this.hotelService.getHotels());
    }
    @GetMapping("/get/{hid}")
    public ResponseEntity<HotelDTO> getHotel(@PathVariable String hid)
    {
       HotelDTO hotelDTO =this.hotelService.getSingleHotel(hid);
        return ResponseEntity.ok(hotelDTO);
    }
}
