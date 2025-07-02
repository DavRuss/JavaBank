public abstract class Account implements Authenticatable {
    private String accountNumber;
    private double balance;
    private String pin;

    public Account(String accountNumber, double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount) throws InsufficientFundsException;

    @Override
    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }



    public void mostrarSaldo() {
        System.out.println("Saldo actual: " + this.balance);
    }

}

