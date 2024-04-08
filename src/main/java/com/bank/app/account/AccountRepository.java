package com.bank.app.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<BankAccount, Long> {
    //    select * from Account where email
    @Query("SELECT a FROM BankAccount a WHERE a.email = ?1")
    Optional<BankAccount> findBankAccountByEmail(String email);
}

