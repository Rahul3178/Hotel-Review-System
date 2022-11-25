package com.hotelreview.HotelService.exceptions;


public class ResourceNotFoundException extends RuntimeException
{
    String resourceName;
    String filedName;
    String fieldValue;
    public ResourceNotFoundException(String resourceName, String filedName, String fieldValue)
    {
        super(String.format("%s not found with %s : %s",resourceName,filedName,fieldValue));
        this.resourceName=resourceName;
        this.filedName=filedName;
        this.fieldValue=fieldValue;

    }
}
