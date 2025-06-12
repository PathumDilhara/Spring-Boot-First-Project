package com.example.demo_new.services;

import com.example.demo_new.dto.UserDTO;
import com.example.demo_new.entity.User;
import com.example.demo_new.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServices {

//    Entities may contain sensitive data (e.g., passwords, roles, etc.) that you don’t want to expose to the frontend.
//    Your database schema (Entity) shouldn't control your API output. If DB changes, your frontend breaks.
//    DTOs let you define different validation rules for input/output (e.g., @NotNull for incoming requests).
//    You might want to send only part of the data (e.g., name and email, but not address or id).
//    One entity can have multiple DTOs depending on the use case (e.g., UserLoginDTO, UserProfileDTO).
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser  (UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User> allUsers = userRepo.findAll(); // assign all stored data in UserRepo(DB) in type 'User' to allUser list variable
        // Type listType = new TypeToken<List<UserDTO>>() {}.getType();
        // modelMapper.map(allUsers, listType);

        return modelMapper.map(allUsers, new TypeToken<List<UserDTO>>(){}.getType()); // mapping / converting entity list ---> DTO list
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }
}
