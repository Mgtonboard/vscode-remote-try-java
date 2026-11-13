package com.bank.model;

import java.time.LocalDate;

public class ChequeAccount extends Account implements Withdrawable {
    private final String employerName;
    private final String employerAddress;

    public ChequeAccount(int accountNumber, double balance, LocalDate dateOpened,
                         String employerName, String employerAddress) {
        super(accountNumber, balance, dateOpened);
        if (employerName == null || employerName.isBlank()) {
            throw new IllegalArgumentException(
                "Cheque accounts require employment information.");
        }
        this.employerName = employerName;
        this.employerAddress = employerAddress;
    }

    @Override
    public boolean withdraw(double amount) {
        return debit(amount);
    }

    public String getEmployerName()    { return employerName; }
    public String getEmployerAddress() { return employerAddress; }

    @Override public String getAccountType() { return "Cheque"; }
}