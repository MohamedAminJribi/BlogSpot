package com.example.sparkit.fr.BlogSpot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private  String userName;
    private  String email;
    private  String password;
    private  Boolean  isAdmin  ;


}
