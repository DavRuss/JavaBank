package ATM;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance, pin);
        this.interestRate = interestRate;
    }

    public SavingsAccount(String number, double initialBalance) {
        super();
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }
}
