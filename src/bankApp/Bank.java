package bankApp;

import java.util.ArrayList;


public class Bank {
    private String name;
    private String bankName;
    private int pin;
    private int count;
    private String bankCode;
    private final int[] weights = {3, 7, 3, 3, 7, 3, 3, 7, 3, 3, 7, 3};


    private final ArrayList<Account> accounts = new ArrayList<>();


    public Bank(String bankName, String bankCode) {
        this.bankName = bankName;
        this.bankCode = bankCode;
    }

    public Account registerCustomer(String firstName, String lastName , int pin) {
        String accountNumber = generateAccountNumber();

        Account newAccount = new Account(accountNumber);
        newAccount.setPin(pin);

        this.accounts.add(newAccount);
        count = count + 1;

        this.name = firstName + " " + lastName;
        this.pin = pin;
        return newAccount;
    }

//    Create a unique 9 digit number
//    Add the bankcode to the serial number
//    Multiply the weights by the combined numbers
//    Sum up the result
//    Sum % 10
//    remainder - 10
//    add value to the serial number

    private String generateAccountNumber() {
        String serialNumber = String.format("%09d", count + 1);
        String checkSum = this.bankCode + serialNumber;
        int sum = 0;
        for(int count = 0; count < weights.length; count++) {
            int digit = Character.getNumericValue(checkSum.charAt(count));
            sum += digit * weights[count];
        }

        int check_digit = (sum % 10) - 10;
        return serialNumber + 1;
    }




    public int getNumberOfRegisteredAccount() {
        return count;
    }

    public Account findAccountNumber(String accountNumber) {
        for(Account account : this.accounts) {
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, int amount) {
        Account account = findAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account number " + accountNumber + " not found!");
        }
        account.deposit(amount);
    }

    public int checkBalance(int pin, String accountNumber) {
        Account account = findAccountNumber(accountNumber);
        account.enterPin(pin);
        return account.getBalance();
    }


    public void removeAccount(int pin, String accountNumber) {
        Account account = findAccountNumber(accountNumber);
        if(account.getAccountNumber().equals(accountNumber)) {
            accounts.remove(account);
        }
    }


    public void transfer(int amount, String sender, String receiver, int pin) {
        if(sender.equals(receiver)) throw new IllegalArgumentException("Can't send to the same account!!!");
        Account senderAccount = findAccountNumber(sender);
        Account receiverAccount = findAccountNumber(receiver);

        senderAccount.withdraw(amount);
        receiverAccount.deposit(amount);
    }



    public void withdraw(String accountNumber, int amount, int pin) {
        if(amount >= this.checkBalance(pin, accountNumber)) throw new IllegalArgumentException("Insufficient Balance!!!");
        if(amount < 1) throw new IllegalArgumentException("Amount must be greater than 1!!!");
        Account account = findAccountNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account number " + accountNumber + " not found!");
        }
        account.withdraw(amount);
    }




}
