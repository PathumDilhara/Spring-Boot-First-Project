package com.example.demo_new.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {

    @GetMapping("/getUser")
    public String getUser(){
        return "test user";
    }

    @PostMapping("/saveUser")
    public String saveUser(){
        return "test user saved";
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
