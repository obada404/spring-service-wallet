package com.mocProject.Wallet.repository;

import com.mocProject.Wallet.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
      List<Transaction> findAllByWalletId(int walletId) ;
      Transaction findByWalletIdAndId(int walletId,int id);


}
