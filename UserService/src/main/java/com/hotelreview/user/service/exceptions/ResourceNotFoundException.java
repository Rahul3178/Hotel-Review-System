package com.hotelreview.user.service.exceptions;

public class ResourceNotFoundException extends Exception
{
    String resourceName;
    String filedName;
    Integer fieldValue;
        public ResourceNotFoundException(String resourceName,String fieldName,Integer fieldValue)
        {
            super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
            this.fieldValue=fieldValue;
            this.resourceName=resourceName;
            this.filedName=fieldName;
        }
}
