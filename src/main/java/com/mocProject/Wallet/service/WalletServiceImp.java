package com.mocProject.Wallet.service;

import com.mocProject.Wallet.DTO.WalletDTO;
import com.mocProject.Wallet.entity.Wallet;
import com.mocProject.Wallet.repository.UserRepository;
import com.mocProject.Wallet.repository.WalletRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WalletServiceImp implements WalletService   {

    private UserRepository userRepository;
    private WalletRepository walletRepository;
    private ModelMapper modelMapper;

    @Autowired
    public WalletServiceImp(UserRepository userRepository, WalletRepository walletRepository, ModelMapper modelMapper) {

        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Wallet createWallet(int userId) {

        Wallet wallet =new Wallet();

        wallet.setUser(userRepository.getReferenceById(userId));
        walletRepository.save(wallet);
        return wallet;

    }

    @Override
    public void deposit(int userId, float amount) throws Exception {

      Wallet wallet = walletRepository.findByUserId(userId);
      wallet.setBalance(wallet.getBalance() + amount);

    }

    @Override
    public void withdraw(int userId, int amount) throws Exception {

        Wallet wallet = walletRepository.findByUserId(userId);
        if(wallet.getBalance() > amount)
            wallet.setBalance(wallet.getBalance() - amount);
        else
            throw new Exception(" no enough money");

    }

    @Override
    public WalletDTO getUserWalletDTO(int userId) {
        Wallet wallet = walletRepository.findByUserId(userId);

        WalletDTO walletDTO = modelMapper.map(wallet, WalletDTO.class);

        return walletDTO;

    }
}
