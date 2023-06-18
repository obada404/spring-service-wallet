package com.mocProject.Wallet.controller;

import com.mocProject.Wallet.DTO.TransactionDTO;
import com.mocProject.Wallet.DTO.UserDTO;
import com.mocProject.Wallet.DTO.UserLogin;
import com.mocProject.Wallet.DTO.WalletDTO;
import com.mocProject.Wallet.entity.Transaction;
import com.mocProject.Wallet.entity.User;
import com.mocProject.Wallet.repository.TransactionRepository;
import com.mocProject.Wallet.repository.UserRepository;
import com.mocProject.Wallet.repository.WalletRepository;
import com.mocProject.Wallet.service.TransactionService;
import com.mocProject.Wallet.service.UserService;
import com.mocProject.Wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController( UserService userService) {

        this.userService = userService;
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
    public UserDTO postUser(@RequestBody User user){

        UserDTO savedUserDTO = userService.createUser(user);
        return savedUserDTO;


              // I can create it using user service but I think its still working

    }
    @PostMapping ("/login")
    public UserDTO loginUser(@RequestBody UserLogin userlogin){

       return userService.login(userlogin);

    }


}
