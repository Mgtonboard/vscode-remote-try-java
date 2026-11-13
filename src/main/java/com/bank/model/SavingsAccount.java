package com.bank.model;

import java.time.LocalDate;

public class SavingsAccount extends Account implements InterestBearing {
    public static final double MONTHLY_RATE = 0.0005; // 0.05%

    public SavingsAccount(int accountNumber, double balance, LocalDate dateOpened) {
        super(accountNumber, balance, dateOpened);
    }

    // Overloaded constructor for a new account
    public SavingsAccount(int accountNumber, double openingDeposit) {
        this(accountNumber, openingDeposit, LocalDate.now());
    }

    @Override
    public double calculateMonthlyInterest() {
        return Math.round(getBalance() * MONTHLY_RATE * 100.0) / 100.0;
    }

    @Override
    public void payInterest() {
        double interest = calculateMonthlyInterest();
        if (interest > 0) {
            deposit(interest);
        }
    }

    @Override public String getAccountType() { return "Savings"; }
}