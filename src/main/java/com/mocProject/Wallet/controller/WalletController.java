package com.mocProject.Wallet.controller;

import com.mocProject.Wallet.DTO.UserDTO;
import com.mocProject.Wallet.DTO.UserLogin;
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
    private UserRepository userRepository;
    private TransactionRepository transactionRepository;
    private WalletRepository walletRepository;
    private final UserService userService;
    private final TransactionService transactionService;

    @Autowired
    public WalletController(WalletService walletService, UserRepository userRepository,
                            TransactionRepository transactionRepository,
                            WalletRepository walletRepository, UserService userService, TransactionService transactionService) {
        this.walletService = walletService;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
        this.userService = userService;
        this.transactionService = transactionService;
    }

    @GetMapping("decrease-balance")
    public String decreaseBalance (){

        return"decrease-balance vale";

    }

    @GetMapping("/users")
    public List<User> getUsers(){

      return userRepository.findAll();

    }
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId){

        return userRepository.findById(userId).get();

    }

    @PostMapping ("/users")
    public User postUser(@RequestBody User user){


              User userTmp=  userRepository.save(user);
              walletService.createWallet(user.getId());
              return userTmp;

              // I can create it using user service but I think its still working

    }
    @PostMapping ("/login")
    public UserDTO loginUser(@RequestBody UserLogin userlogin){

       return userService.login(userlogin);

    }
    @GetMapping ("/wallets/{userId}")
    public Wallet getUserWallet(@PathVariable int  userId){

        return walletRepository.findByUserId(userId);

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
    public List<Transaction> transactionHistory(@PathVariable int userId ){

          return transactionService.findAllByUserId(userId);

    }
    @GetMapping ("/wallets/{userId}/transactions/{transactionsId}")
    public Transaction getTransaction(@PathVariable int userId , @PathVariable int transactionsId){

        return transactionService.getTransactionForUserById(userId,transactionsId);

    }
    @PostMapping ("/wallets/{userId}/transactions")
    public Wallet addTransaction(@PathVariable int userId
    , @RequestBody Transaction transaction) throws Exception {

        return transactionService.addTransaction(transaction,userId);
    }



}
