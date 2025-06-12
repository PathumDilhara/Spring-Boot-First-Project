package com.example.demo_new.controller;

import com.example.demo_new.dto.UserDTO;
import com.example.demo_new.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/getUser")
    public String getUser(){
        return "test user";
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
       return userServices.saveUser(userDTO);
//        return "test user saved";
    }

    @PutMapping("/updateUser")
    public String updateUser(){
        return "test user updated";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(){
        return "test user deleted";
    }
}
