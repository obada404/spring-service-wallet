package com.mocProject.Wallet.service;

import com.mocProject.Wallet.DTO.UserDTO;
import com.mocProject.Wallet.DTO.UserLogin;
import com.mocProject.Wallet.entity.User;
import com.mocProject.Wallet.entity.Wallet;
import com.mocProject.Wallet.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImp implements UserService {

    private final ModelMapper modelMapper ;

    private final UserRepository userRepository;
    private WalletService walletService;

    @Autowired
    public UserServiceImp(UserRepository userRepository, ModelMapper modelMapper, WalletService walletService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.walletService = walletService;
    }


    @Override
    public UserDTO login(UserLogin userLogin) {
        User user= userRepository.findByEmailAndPassword(userLogin.getEmail(),userLogin.getPassword());
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserDTOById(int userId) {
     User user= userRepository.findById(userId).get();
      return   modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO createUser(User user) {

        User userSaved=  userRepository.save(user);
        walletService.createWallet(user.getId());
        return modelMapper.map(userSaved, UserDTO.class);
//        you might need to
//        Wallet wallet =new Wallet();
//
//        wallet.setUser(userRepository.getReferenceById(userId));
//        walletRepository.save(wallet);
//        return wallet;
    }
}
