package com.hotelreview.user.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "micro_users")
public class User
{
    @Id
    @Column(name = "user_id")
    private int userId;

    private String userName;
    private String userEmail;
    private String aboutUser;

    // We can write other properties also
    @Autowired
    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
