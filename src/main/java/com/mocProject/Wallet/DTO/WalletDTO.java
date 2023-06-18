package com.mocProject.Wallet.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mocProject.Wallet.entity.Transaction;
import com.mocProject.Wallet.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WalletDTO {

        private int id;
        private UserDTO user;
        List<TransactionDTO> transactions;
        private  float balance;


    }
