package com.bank.model;

import java.time.LocalDate;

public class InvestmentAccount extends Account
        implements InterestBearing, Withdrawable {
    public static final double MONTHLY_RATE = 0.05; // 5%
    public static final double MIN_OPENING_DEPOSIT = 500.00;

    public InvestmentAccount(int accountNumber, double balance, LocalDate dateOpened) {
        super(accountNumber, balance, dateOpened);
    }

    public InvestmentAccount(int accountNumber, double openingDeposit) {
        this(accountNumber, openingDeposit, LocalDate.now());
    }

    @Override
    public boolean withdraw(double amount) {
        return debit(amount);
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

    @Override public String getAccountType() { return "Investment"; }
}