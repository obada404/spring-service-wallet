package com.mocProject.Wallet.service;

import com.mocProject.Wallet.DTO.TransactionDTO;
import com.mocProject.Wallet.DTO.WalletDTO;
import com.mocProject.Wallet.entity.Transaction;

import java.util.List;

public interface TransactionService {
    WalletDTO addTransaction(Transaction transaction, int userId) throws Exception;

    List<TransactionDTO> findAllTransactionByUserId(int userId);

    TransactionDTO getTransactionForUserById(int userId, int transactionsId);
}
