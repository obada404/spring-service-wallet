package com.mocProject.Wallet.DTO;



import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TransactionDTO {

    private float amount;
    private Date transactionDate;

}
