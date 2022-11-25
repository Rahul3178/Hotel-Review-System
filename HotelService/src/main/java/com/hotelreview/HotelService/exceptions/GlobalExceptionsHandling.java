package com.hotelreview.HotelService.exceptions;

import com.hotelreview.HotelService.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandling
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex)
    {
        String message=ex.getMessage();
        return new ResponseEntity<>(new ApiResponse(message,false), HttpStatus.NOT_FOUND);
    }
}
