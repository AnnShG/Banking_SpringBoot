package com.bank.app.account;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<BankAccount> getAccount() {
        return accountRepository.findAll();
    }

    public void addNewAccount(BankAccount account) {
        Optional<BankAccount> accountOptional = accountRepository.findBankAccountByEmail(account.getEmail());
        if (accountOptional.isPresent()) {
            throw new IllegalStateException("this " + account.getEmail() + " email taken");
        }
        accountRepository.save(account);
    }

    public void deleteAccount(Long accountId) {
        boolean exists = accountRepository.existsById(accountId);
        if (!exists) {
            throw new IllegalStateException("account with id" + " " + accountId + " does not exist");
        }
        accountRepository.deleteById(accountId);
    }

    @Transactional
    public void updateAccount(Long accountId, String login, String email) {
        BankAccount account = accountRepository.findById(accountId).orElseThrow(() -> new IllegalStateException(
                "account with id " + " " + accountId + " does not exist"));

        if (login != null && login.length() > 0 && !Objects.equals(account.getLogin(), login)) {
            account.setLogin(login);
        }

        if (email != null && email.length() > 0 && !Objects.equals(account.getEmail(), email)) {
            Optional<BankAccount> accountOptional = accountRepository.findBankAccountByEmail(email);
            if (accountOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            account.setEmail(email);
        }
    }

}
