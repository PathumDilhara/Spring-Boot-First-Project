package com.example.demo_new.controller;

import com.example.demo_new.dto.UserDTO;
import com.example.demo_new.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/getUser")
    public List<UserDTO> getUser(){
        return userServices.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
       return userServices.saveUser(userDTO);
       // return "test user saved";
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userServices.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
        return userServices.deleteUser(userDTO);
    }
}
