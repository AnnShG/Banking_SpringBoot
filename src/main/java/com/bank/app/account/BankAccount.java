package com.bank.app.account;


import jakarta.persistence.*;

@Entity
@Table
public class BankAccount {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long id;
    private String login;
    private String email;
    private double balance;
//    private int password;

    public BankAccount() {
    }
    public BankAccount(Long id, String login, String email, double balance) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.balance = balance;
//        this.password = password;
    }

    public BankAccount(String login, String email, double balance) {
        this.login = login;
        this.email = email;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String setLogin(String login) {
        return login;
    }

    public String getLogin() {
        return login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
}
