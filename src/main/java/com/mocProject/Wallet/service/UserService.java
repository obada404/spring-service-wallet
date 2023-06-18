package com.mocProject.Wallet.service;
import com.mocProject.Wallet.DTO.UserDTO;
import com.mocProject.Wallet.DTO.UserLogin;
import com.mocProject.Wallet.entity.User;

import java.util.List;

public interface UserService {

    UserDTO login(UserLogin userLogin);

    List<UserDTO> getAllUsers();

    UserDTO getUserDTOById(int userId);

    UserDTO createUser(User user);
}
