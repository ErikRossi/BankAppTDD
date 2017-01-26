package bankaccount;

//--------TO-DO
//-Introduce MAVEN support.
//-Write error messages for every state.
//-Show error message to user, so they know what happened why it error.
//


public class BankAccount {

    private double balance;
    
    public double getBalance(BankAccount ba) {
        return ba.balance;
    }
    
    //Method for testing purposes only.
    public void setBalance(BankAccount ba, int i) {
        balance = i;
    }
    
    
    //Functionality for depositing money.
    public void deposit(BankAccount ba, int i) {
        //Makes sure you can't deposit negative amounts.
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        //Successful deposit.
        else {
            balance += i;
        }
    }

    //Functionality for withdrawing money.
    public void withdraw(BankAccount ba, int i) {     
        //Can't withdraw if requested amount is negative.
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        //Can't withdraw if balance is less than or equal to zero.
        if (ba.getBalance(ba) <= 0) {
            throw new ArithmeticException();
        }
        //Cannot withdraw amounts that exceeds balance of -100.
        if (ba.getBalance(ba) - i < -100) {
            throw new IllegalStateException();
        }
        //Successful withdrawal.
        else {
            ba.balance -= i;
        }
        //Five dollar penalty if customer overdraws.
        if (ba.balance < 0) {
            ba.balance -= 5;
        }
    }
    
    
}
