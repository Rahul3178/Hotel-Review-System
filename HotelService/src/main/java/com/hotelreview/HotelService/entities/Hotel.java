package com.hotelreview.HotelService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



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
