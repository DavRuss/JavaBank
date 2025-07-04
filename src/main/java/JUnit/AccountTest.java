package JUnit;

import ATM.Account;
import ATM.SavingsAccount;
import Excepciones.InsufficientFundsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void testWithdraw() throws InsufficientFundsException {
        Account account = new SavingsAccount("12345", 500.00);
        account.withdraw(100.00);
        assertEquals(400.00, account.getBalance());
    }


//    @DataProvider(name = "withdrawData")
//    public Object[][] createData() {
//        return new Object[][] {
//                {500.00, 100.00, 400.00},
//                {300.00, 50.00, 250.00}
//        };
//    }
//
//    @Test(dataProvider = "withdrawData")
//    public void testWithdraw(double initialBalance, double amount, double expectedBalance) {
//        Account account = new SavingsAccount("12345", initialBalance);
//        account.withdraw(amount);
//        assertEquals(account.getBalance(), expectedBalance);
//    }
}
