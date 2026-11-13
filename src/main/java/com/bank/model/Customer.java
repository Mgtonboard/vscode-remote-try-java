package com.bank.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private final String customerId;
    private String customerName;
    private String customerPhoneNumber;
    private final List<Account> accounts = new ArrayList<>();

    public Customer(String customerId, String customerName,
                    String customerPhoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void addAccount(Account account) { accounts.add(account); }

    public List<Account> viewAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public String getCustomerId()          { return customerId; }
    public String getCustomerName()        { return customerName; }
    public String getCustomerPhoneNumber() { return customerPhoneNumber; }

    @Override
    public String toString() { return customerId + " - " + customerName; }
}