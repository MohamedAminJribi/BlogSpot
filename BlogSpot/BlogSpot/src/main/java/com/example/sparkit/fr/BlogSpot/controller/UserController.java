package com.example.sparkit.fr.BlogSpot.controller;

import com.example.sparkit.fr.BlogSpot.Dto.LoginDto;
import com.example.sparkit.fr.BlogSpot.Dto.UserDto;
import com.example.sparkit.fr.BlogSpot.entity.User;
import com.example.sparkit.fr.BlogSpot.response.LoginResponse;
import com.example.sparkit.fr.BlogSpot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping(path= "/save")
    public String saveUser(@RequestBody UserDto userDTO){
        return userService.addUser(userDTO);
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginuser(@RequestBody LoginDto loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @DeleteMapping(value = "/{id}")
    public String deletUser(@PathVariable(value = "id")long user_id ){
        return userService.deletUser(user_id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody UserDto userDTO){
      return   userService.updateUser(userDTO);
    }


}
