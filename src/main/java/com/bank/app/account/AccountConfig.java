package com.bank.app.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountConfig {
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository repository) {
        return args -> {
            //id clear
            BankAccount account1 = new BankAccount (1L, "lala", "lala@gmail.com", 10);
            BankAccount account2 = new BankAccount ( 2L, "lalala", "lalala@gmail.com", 1);

            repository.saveAll(
                    List.of(account1, account2)
            );
        };
    }
}
