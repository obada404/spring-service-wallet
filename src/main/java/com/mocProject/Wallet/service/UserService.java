package com.mocProject.Wallet.service;
import com.mocProject.Wallet.DTO.UserDTO;
import com.mocProject.Wallet.DTO.UserLogin;

public interface UserService {

    UserDTO login(UserLogin userLogin);

}
