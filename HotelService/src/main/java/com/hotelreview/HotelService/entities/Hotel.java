package com.hotelreview.HotelService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "micro_hotel")
public class Hotel
{
    @Id
    private String hotelId;
    private  String hotelName;
    private String hotelLocation;
    private String aboutHotel;


}
