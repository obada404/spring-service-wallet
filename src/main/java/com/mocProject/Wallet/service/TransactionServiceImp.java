package com.mocProject.Wallet.service;

import com.mocProject.Wallet.entity.Transaction;
import com.mocProject.Wallet.entity.Wallet;
import com.mocProject.Wallet.repository.TransactionRepository;
import com.mocProject.Wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionServiceImp implements TransactionService   {


    private TransactionRepository transactionRepository;
    private WalletRepository walletRepository;

    @Autowired
    public TransactionServiceImp(TransactionRepository transactionRepository, WalletRepository walletRepository) {
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet addTransaction(Transaction transaction, int userId) throws Exception {


        Wallet wallet = walletRepository.findByUserId(userId);
        if (wallet != null) {
            transaction.setWallet(wallet);

        }else
            throw new Exception("no Wallet with this Id ");

        transactionRepository.save(transaction);
        wallet.getTransactions().add(transaction);
        wallet.setBalance(wallet.getBalance()+transaction.getAmount());
        walletRepository.save(wallet);

        return wallet;
    }

    @Override
    public List<Transaction> findAllByUserId(int userId) {
        Wallet wallet = walletRepository.findByUserId(userId);
        return transactionRepository.findAllByWalletId(wallet.getId());


    }

    @Override
    public Transaction getTransactionForUserById(int userId, int transactionsId) {
        Wallet wallet = walletRepository.findByUserId(userId);

       return transactionRepository.findByWalletIdAndId(wallet.getId(),transactionsId);
    }
}
