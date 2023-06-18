package com.mocProject.Wallet.controller;

import com.mocProject.Wallet.DTO.TransactionDTO;
import com.mocProject.Wallet.DTO.UserDTO;
import com.mocProject.Wallet.DTO.UserLogin;
import com.mocProject.Wallet.DTO.WalletDTO;
import com.mocProject.Wallet.entity.Transaction;
import com.mocProject.Wallet.entity.User;
import com.mocProject.Wallet.entity.Wallet;
import com.mocProject.Wallet.repository.TransactionRepository;
import com.mocProject.Wallet.repository.UserRepository;
import com.mocProject.Wallet.repository.WalletRepository;
import com.mocProject.Wallet.service.TransactionService;
import com.mocProject.Wallet.service.UserService;
import com.mocProject.Wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {


    private WalletService walletService;
    private TransactionRepository transactionRepository;
    private final TransactionService transactionService;

    @Autowired
    public WalletController(WalletService walletService, TransactionRepository transactionRepository
            , TransactionService transactionService) {
        this.walletService = walletService;
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    @GetMapping ("/wallets/{userId}")
    public WalletDTO getUserWallet(@PathVariable int  userId){
        WalletDTO walletDTO = walletService.getUserWalletDTO(userId);
        return walletDTO;


    }
    @PostMapping ("/wallets/{userId}/deposit")
    public void deposit(@PathVariable int userId,@RequestBody float amount) throws Exception {
        walletService.deposit(userId,amount);

    }
    @PostMapping ("/wallets/{userId}/withdraw")
    public void withdraw(@PathVariable int userId, @PathVariable int walletId,@RequestBody int amount) throws Exception {

            walletService.withdraw(userId,amount);

    }
    @GetMapping ("/wallets/{userId}/transactions")
    public List<TransactionDTO> transactionHistory(@PathVariable int userId ){

          return transactionService.findAllTransactionByUserId(userId);

    }
    @GetMapping ("/wallets/{userId}/transactions/{transactionsId}")
    public TransactionDTO getTransaction(@PathVariable int userId , @PathVariable int transactionsId){

        return transactionService.getTransactionForUserById(userId,transactionsId);

    }
    @PostMapping ("/wallets/{userId}/transactions")
    public WalletDTO addTransaction(@PathVariable int userId
    , @RequestBody Transaction transaction) throws Exception {

        return transactionService.addTransaction(transaction,userId);
    }



}
