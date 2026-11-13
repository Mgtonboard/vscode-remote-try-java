     package com.bank.model;

  

   public class App {
       public static void main(String[] args) {
           Customer c = new Customer("C001", "Test Customer", "71234567");

           SavingsAccount s = new SavingsAccount(1001, 1000);
           s.payInterest();
           InvestmentAccount i = new InvestmentAccount(1002, 500);
           boolean ok = i.withdraw(100);
           boolean tooMuch = i.withdraw(5000);

           c.addAccount(s);
           c.addAccount(i);
           c.viewAccounts().forEach(System.out::println);

           System.out.println("Investment withdraw ok: " + ok);
           System.out.println("Overdraw allowed: " + tooMuch);
           System.out.println("Savings withdrawable: " + (s instanceof Withdrawable));
       }
   }