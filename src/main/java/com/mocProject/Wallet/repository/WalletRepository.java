package com.mocProject.Wallet.repository;

import com.mocProject.Wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
    Wallet findByUserId(int userId);



}
