public class Account {
    private String accountNumber;
    private double balance;

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > this.balance) {
            throw new InsufficientFundsException();
        }
        this.balance -= amount;
    }

    public void mostrarSaldo() {
        System.out.println("Saldo actual: " + this.balance);
    }

}

