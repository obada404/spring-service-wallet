package com.mocProject.Wallet.service;

import com.mocProject.Wallet.DTO.TransactionDTO;
import com.mocProject.Wallet.DTO.WalletDTO;
import com.mocProject.Wallet.entity.Transaction;
import com.mocProject.Wallet.entity.Wallet;
import com.mocProject.Wallet.exeptionHandling.entityNotFoundException;
import com.mocProject.Wallet.repository.TransactionRepository;
import com.mocProject.Wallet.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionServiceImp implements TransactionService   {


    private TransactionRepository transactionRepository;
    private WalletRepository walletRepository;
    private ModelMapper modelMapper;

    @Autowired
    public TransactionServiceImp(TransactionRepository transactionRepository, WalletRepository walletRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public WalletDTO addTransaction(Transaction transaction, int userId) throws Exception {


        Wallet wallet = walletRepository.findByUserId(userId);
        if (wallet != null) {
            transaction.setWallet(wallet);

        }else
            throw new entityNotFoundException("no Wallet with this Id ");

        transactionRepository.save(transaction);
        wallet.getTransactions().add(transaction);
        wallet.setBalance(wallet.getBalance()+transaction.getAmount());
        walletRepository.save(wallet);
        return modelMapper.map(wallet,WalletDTO.class);
    }

    @Override
    public List<TransactionDTO> findAllTransactionByUserId(int userId) {
        Wallet wallet = walletRepository.findByUserId(userId);
        List<Transaction>  transactions = transactionRepository.findAllByWalletId(wallet.getId());
        List<TransactionDTO> transactionDTOs = transactions.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDTO.class))
                .collect(Collectors.toList());

        return  transactionDTOs;
    }

    @Override
    public TransactionDTO getTransactionForUserById(int userId, int transactionsId) {
        Wallet wallet = walletRepository.findByUserId(userId);

       Transaction transaction= transactionRepository.findByWalletIdAndId(wallet.getId(),transactionsId);

       return  modelMapper.map(transaction,TransactionDTO.class);
    }
}
