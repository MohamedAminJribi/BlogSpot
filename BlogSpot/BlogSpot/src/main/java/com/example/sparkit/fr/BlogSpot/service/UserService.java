package com.example.sparkit.fr.BlogSpot.service;

import com.example.sparkit.fr.BlogSpot.Dto.LoginDto;
import com.example.sparkit.fr.BlogSpot.Dto.UserDto;
import com.example.sparkit.fr.BlogSpot.entity.User;
import com.example.sparkit.fr.BlogSpot.response.LoginResponse;

public interface UserService {


    String addUser(UserDto userDTO);
    LoginResponse loginUser(LoginDto loginDTO);
    String deletUser(long user_id);

    User updateUser(UserDto userDTO);

}
