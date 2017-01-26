package testbankaccount;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import bankaccount.BankAccount;
import static org.junit.Assert.*;

public class TestBankAccount {
    
    BankAccount ba = new BankAccount();
    
    public TestBankAccount() {
    }
    
    //Sets ba's balance to 0.
    @Before
    public void setUp() {
        ba.deposit(ba,0);
    }

    //Test standard, run-of-the-mill deposits.
    @Test
    public void testDeposit() {
        assertEquals(0,ba.getBalance(ba),0);
        ba.deposit(ba, 500);
        assertEquals(500,ba.getBalance(ba),0);
    }
    
    //Disallows deposits of negative amounts. To prevent typos.
    @Test(expected=IllegalArgumentException.class)
    public void testDepositWithNegativeAmount() {
        ba.deposit(ba, -100);
    }    
    
    //Tests whether standard withdrawal functionality works.
    @Test
    public void testWithdraw() {
        ba.deposit(ba, 500);
        assertEquals(500,ba.getBalance(ba),0);
        ba.withdraw(ba, 300);
        assertEquals(200, ba.getBalance(ba),0);
    }
    
    //Makes sure negative amounts in code doesn't work.
    @Test (expected=IllegalArgumentException.class)
    public void testWithdrawWithNegativeAmount() {
        ba.withdraw(ba, -100);        
    }
    
    //Test disallow withdrawal when balance is negative.
    @Test (expected = ArithmeticException.class)
    public void testWithdrawWhenBalanceIsNegative() {
        ba.setBalance(ba, -100);
        assertEquals(-100, ba.getBalance(ba), 0);
        ba.withdraw(ba, 100);
    }    
    
    //Gives a -5 dollar penalty if customer withdraws too much.
    @Test
    public void testBalanceAfterPenaltyIsIncurred() {
        ba.withdraw(ba, 100);
        assertEquals(-105, ba.getBalance(ba), 0);
    }
    
    //Test disallowance of withdrawal if user tries to go over -100 balance.
    //Withdrawal is thereafter cancelled.
    @Test (expected=IllegalStateException.class)
    public void testWithdrawMaximumNegativeAmount() { 
        ba.deposit(ba, 1);
        assertEquals(1, ba.getBalance(ba), 0);
        ba.withdraw(ba, 200);
        assertEquals(1, ba.getBalance(ba), 0);
    }
    
}
