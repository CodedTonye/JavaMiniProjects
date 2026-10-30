package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest{

    private Account myAccount;

    @BeforeEach
    public void setUp() {
        myAccount = new Account();
        myAccount.setPin(1234);
    }
    @Test
    public void deposit200_balanceIs200Test() {
        myAccount.enterPin(1234);
        assertEquals(0,myAccount.getBalance());

        myAccount.deposit(200);
        myAccount.enterPin(1234);
        assertEquals(200, myAccount.getBalance());
    }

    @Test
    public void deposit200AndThen500_balanceIs700Test() {
        myAccount.enterPin(1234);
        assertEquals(0,myAccount.getBalance());

        myAccount.deposit(200);
        myAccount.deposit(500);
        myAccount.enterPin(1234);
        assertEquals(700, myAccount.getBalance());
    }

    @Test
    public void depositNegative200_balanceIsZeroTest() {
        myAccount.deposit(-200);
        myAccount.enterPin(1234);
        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void withdraw500From0_balanceIs0() {
        myAccount.withdraw(500);
        myAccount.enterPin(1234);
        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void withdraw500From5000_balanceIs4500Test() {

        myAccount.deposit(5000);
        myAccount.enterPin(1234);
        assertEquals(5000, myAccount.getBalance());

        myAccount.withdraw(500);
        myAccount.enterPin(1234);
        assertEquals(4500, myAccount.getBalance());
    }

    @Test
    public void withdrawNegative500From5000_balanceIs5000() {
        myAccount.deposit(5000);
        myAccount.enterPin(1234);
        assertEquals(5000, myAccount.getBalance());

        myAccount.withdraw(-500);
        myAccount.enterPin(1234);
        assertEquals(5000, myAccount.getBalance());
    }

    @Test
    public void withdraw500from500_balanceIs0Test() {
        myAccount.deposit(500);
        myAccount.enterPin(1234);
        assertEquals(500, myAccount.getBalance());

        myAccount.withdraw(500);
        myAccount.enterPin(1234);
        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void AccountDeposited500_withdrawWithoutPin_throwError() {
        myAccount.deposit(500);

        myAccount.withdraw(200);
        myAccount.enterPin(1234);
        assertEquals(500, myAccount.getBalance());
    }

    @Test
    public void AccountDeposited_CheckBalance_throwErrorTest() {
        myAccount.deposit(500);
        assertThrows(IllegalArgumentException.class, ()-> myAccount.getBalance());
    }


}
