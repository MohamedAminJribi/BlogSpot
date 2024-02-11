package com.example.sparkit.fr.BlogSpot.service.impl;

import com.example.sparkit.fr.BlogSpot.Dto.LoginDto;
import com.example.sparkit.fr.BlogSpot.Dto.UserDto;
import com.example.sparkit.fr.BlogSpot.Exeption.HttpCustomException;
import com.example.sparkit.fr.BlogSpot.entity.User;
import com.example.sparkit.fr.BlogSpot.repo.UserRepo;
import com.example.sparkit.fr.BlogSpot.response.LoginResponse;
import com.example.sparkit.fr.BlogSpot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.sparkit.fr.BlogSpot.Exeption.ErrorCode.USER_NOT_FOUND;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public String addUser(UserDto userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                false

        );
        userRepo.save(user);
        return user.getUserName();
    }


    @Override
    public LoginResponse loginUser(LoginDto loginDTO) {
        User user = userRepo.findByEmail(loginDTO.getEmail()).orElseThrow(()-> new HttpCustomException("user with email not found",USER_NOT_FOUND));
        LoginResponse loginResponse= new LoginResponse("Login failed",false);
        if (user.getPassword().equals(loginDTO.getPassword())){
            loginResponse.setMessage("Login success");
            loginResponse.setStatus(true);
            return loginResponse;
        }
        return loginResponse;
    }

    @Override
    public String deletUser(long user_id) {
        User user=userRepo.findById(user_id).orElseThrow(()-> new HttpCustomException("user to delet not found",USER_NOT_FOUND));

            userRepo.delete(user);
            return("delete succes")  ;
    }

    @Override
    public User updateUser(UserDto userDTO) {
        User user = userRepo.findById(userDTO.getId())
                .orElseThrow(() -> new HttpCustomException("user to update not found", USER_NOT_FOUND));
        user.setEmail(userDTO.getEmail());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());

        return userRepo.save(user);

    }
}




