package com.mocProject.Wallet.service;

import com.mocProject.Wallet.entity.Transaction;
import com.mocProject.Wallet.entity.Wallet;

import java.util.List;

public interface TransactionService {
    Wallet addTransaction(Transaction transaction, int userId) throws Exception;

    List<Transaction> findAllByUserId(int userId);

    Transaction getTransactionForUserById(int userId, int transactionsId);
}
