package com.mocProject.Wallet.controller;

import com.mocProject.Wallet.DTO.UserDTO;
import com.mocProject.Wallet.DTO.UserLogin;
import com.mocProject.Wallet.entity.User;
import com.mocProject.Wallet.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class UserController {


    private final UserService userService;
    private ModelMapper modelMapper;
    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOs = userService.getAllUsers();
        return userDTOs;
    }
    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable int userId){
        UserDTO userDTO = userService.getUserDTOById(userId);
        return userDTO;
    }
    @PostMapping ("/users")
    public UserDTO postUser(@RequestBody @Valid UserDTO userDTO){
        UserDTO savedUserDTO = userService.createUser(modelMapper.map(userDTO, User.class));
        return savedUserDTO;
        // I can create it using user service but I think its still working
    }
    @PostMapping ("/login")
    public UserDTO loginUser(@RequestBody UserLogin userlogin){
       return userService.login(userlogin);
    }


}
