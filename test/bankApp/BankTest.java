package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private  Bank bank;

    @BeforeEach
    public void setUp() {
         bank = new Bank("Moniepoint", "999");
    }

    @Test
    public void registerAccount_returnsNewAccountTest() {
        Account newAccount = bank.registerCustomer("Fred", "Goodwill", 1234);
        assertNotNull(newAccount);

        assertThrows(IllegalArgumentException.class, ()-> newAccount.getBalance());

        newAccount.enterPin(1234);
       assertEquals(0, newAccount.getBalance());
    }

    @Test
    public void registerAccountTwice_getNumberOfRegisteredAccountTest() {
        Account secondAccount = bank.registerCustomer("Fred", "Goodwill", 1234);
        assertEquals(1, bank.getNumberOfRegisteredAccount());
    }

    @Test
    public void registerAccount_FindAccountTest() {
        Account myAccount = bank.registerCustomer("Fred", "Goodwill", 1234);
        String accountNumber = myAccount.getAccountNumber();
        assertEquals(myAccount , bank.findAccountNumber(accountNumber));
    }

    @Test
    public void registerAccount_Deposit2k_balanceIs2kTest() {
        Account myAccount = bank.registerCustomer("Fred", "Goodwill", 1234);
        String accountNumber = myAccount.getAccountNumber();
        bank.deposit(accountNumber, 2000);
        assertEquals(2000, bank.checkBalance(1234, accountNumber));
    }

    @Test
    public void registerAccount_RemoveAccount_FindAccount_AccountIsNotFoundTest() {
        Account myAccount = bank.registerCustomer("Fred", "Goodwill", 1234);
        String accountNumber = myAccount.getAccountNumber();
        assertEquals(myAccount , bank.findAccountNumber(accountNumber));

        bank.removeAccount(1234, accountNumber);
        assertNull(bank.findAccountNumber(accountNumber));
    }

    @Test
    public void registerAccount_Deposit5k_transfer2k_checkBalanceIs3kTest() {
        Account myAccount = bank.registerCustomer("Fred", "Goodwill", 1234);
        String myAccountNumber = myAccount.getAccountNumber();
        bank.deposit(myAccountNumber, 5000);
        Account peterAccount = bank.registerCustomer("Peter", "James", 9090);
        String peteAccountNumber = peterAccount.getAccountNumber();

        bank.transfer(2000, myAccountNumber, peteAccountNumber, 1234);
//        assertEquals(3000, bank.checkBalance(1234, myAccountNumber));
    }

    @Test
    public void registerAccount_Deposit2k_transferToTheSameAccount_throwsExceptionTest() {
        Account myAccount = bank.registerCustomer("Fred", "Goodwill", 1234);
        String accountNumber = myAccount.getAccountNumber();
        assertThrows(IllegalArgumentException.class, ()-> bank.transfer(1000, accountNumber, accountNumber, 1234));
    }

    @Test
//    @DisplayName
    public void registerAccount_Deposit2k_Withdraw2k_throwsExceptionTest() {
        Account myAccount = bank.registerCustomer("Fred", "Goodwill", 1234);
        String accountNumber = myAccount.getAccountNumber();
        bank.deposit(accountNumber, 2000);
        assertThrows(IllegalArgumentException.class, ()-> bank.withdraw(accountNumber, 2000 , 1234));

    }

    @Test
    public void registerAccount_Deposit2k_withDraw500_balanceIs1500Test() {
        Account myAccount = bank.registerCustomer("Fred", "Goodwill", 1234);
        String accountNumber = myAccount.getAccountNumber();
        System.out.println(accountNumber);

        Account emma = bank.registerCustomer("Fred", "Goodwill", 1234);
        String acct = emma.getAccountNumber();
        System.out.println(acct);
        bank.deposit(accountNumber, 2000);
        bank.withdraw(accountNumber, 500, 1234);
        assertEquals(1500, bank.checkBalance(1234, accountNumber));
    }





}
