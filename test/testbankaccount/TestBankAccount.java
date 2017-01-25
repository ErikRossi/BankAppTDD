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
    
    @Before
    public void setUp() {
        ba.deposit(0);
    }

//    @Test
//    public void testReturnBalance() {
//        assertEquals(500, ba.returnBalance(), 0);
//    }
    
    @Test
    public void testDeposit() {
        
        assertEquals(0,ba.returnBalance(),0);
        ba.deposit(500);
        assertEquals(500,ba.returnBalance(),0);
    }
    
    @Test
    public void testWithdraw() {
        ba.deposit(500);
        assertEquals(500,ba.returnBalance(),0);
        ba.withdraw(300);
        assertEquals(200, ba.returnBalance(),0);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testDepositWithNegativeAmount() {
        ba.deposit(-100);
    }
    
    //Test disallow withdrawal when balance is negative.
    @Test
    public void testWithdrawWhenBalanceIsNegative() {
        
    }    
    //Gives a -5 dollar penalty if customer withdraws too much.
    @Test
    public void testBalanceAfterPenaltyIsIncurred() {
        
    }
    
    //Test disallowance of withdrawal if user tries to go over -100 balance.
    @Test
    public void testWithdrawMaximumNegativeAmount() {
        
    }
}
