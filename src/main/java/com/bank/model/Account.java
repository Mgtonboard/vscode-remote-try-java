package com.bank.model;

import java.time.LocalDate;

public abstract class Account {
    private final int accountNumber;
    private double balance;
    private final LocalDate dateOpened;
    private String lastReference;

    protected Account(int accountNumber, double balance, LocalDate dateOpened) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateOpened = dateOpened;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be greater than zero.");
        }
        balance += amount;
    }

    // Overloaded: deposit with a reference
    public void deposit(double amount, String reference) {
        deposit(amount);
        this.lastReference = reference;
    }

    // Used by subclasses that implement Withdrawable
    protected boolean debit(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public abstract String getAccountType();

    public int getAccountNumber()    { return accountNumber; }
    public double getBalance()       { return balance; }
    public LocalDate getDateOpened() { return dateOpened; }
    public String getLastReference() { return lastReference; }

    @Override
    public String toString() {
        return getAccountType() + " " + accountNumber
             + " | Balance: BWP " + String.format("%.2f", balance);
    }
}