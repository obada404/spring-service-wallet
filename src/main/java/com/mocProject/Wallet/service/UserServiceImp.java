package com.mocProject.Wallet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mocProject.Wallet.DTO.UserDTO;
import com.mocProject.Wallet.DTO.UserLogin;
import com.mocProject.Wallet.entity.User;
import com.mocProject.Wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImp implements UserService {

    private final ObjectMapper objectMapper ;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public UserDTO login(UserLogin userLogin) {
        User user= userRepository.findByEmailAndPassword(userLogin.getEmail(),userLogin.getPassword());
        return objectMapper.convertValue(user, UserDTO.class);
    }
}
