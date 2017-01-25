package bankaccount;

public class BankAccount {

    private double balance;
    
    public double returnBalance() {
        return balance;
    }

    public void deposit(int i) {
        //Makes sure you can't deposit negative amounts.
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        else {
        balance += i;
        }
    }

    public void withdraw(int i) {
        balance -= i;
    }
    
    
}
