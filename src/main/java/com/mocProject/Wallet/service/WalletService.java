package com.mocProject.Wallet.service;

import com.mocProject.Wallet.entity.Wallet;

public interface WalletService {


    Wallet createWallet(int userId);

    void deposit(int userId, float amount) throws Exception;

    void withdraw(int userId, int amount) throws Exception;
}
