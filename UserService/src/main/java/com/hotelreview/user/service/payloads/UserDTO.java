package com.hotelreview.user.service.payloads;

import com.hotelreview.user.service.entities.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO
{
    private int userId;

    private String userName;
    private String userEmail;
    private String aboutUser;
    private List<Rating> ratings = new ArrayList<>();
}
