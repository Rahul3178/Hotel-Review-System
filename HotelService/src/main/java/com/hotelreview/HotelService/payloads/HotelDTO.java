package com.hotelreview.HotelService.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO
{
    private String hotelId;
    private  String hotelName;
    private String hotelLocation;
    private String aboutHotel;
}
