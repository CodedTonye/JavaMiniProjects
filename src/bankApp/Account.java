package bankApp;

import java.math.BigDecimal;

public class Account {
    private String accountNumber;
    private int balance = 0;
    private int pin;
    private boolean isAuthenticated;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account() {

    }

    public int getBalance() {
        if(!isAuthenticated) throw new IllegalArgumentException(("Enter pin!!!"));
        return balance;
    }

    public void deposit(int amount) {
        if(amount > 0)balance = balance + amount;
    }

    public void withdraw(int amount) {
        if (isAuthenticated) {
            if (amount > 0 && amount <= balance) balance = balance - amount;
        }

        isAuthenticated = false;
    }

    public void setPin(int pin) {
        if(isValid(pin)) {
            this.pin = pin;
        }
    }

    private boolean isValid(int pin) {
        return pin >= 1000 && pin <= 9999;
    }

    public void enterPin(int pinInput) {
        if(this.pin != 0 && this.pin == pinInput) {
            this.isAuthenticated = true;
        }

    }

    public String getAccountNumber() {
        return accountNumber;
    }

//    private int pinLength() {
//        int count = 0;
//        while(count > 0) {
//            int number = pin % 10;
//            count++;
//            pin /= 10;
//        }
//        return count;
//    }

//    private boolean isAuhenticated() {
//        return isAuthenticated;
//    }
}
