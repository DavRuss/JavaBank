package ATM;

import Excepciones.InsufficientFundsException;

public class CheckingAccount extends Account {

    public CheckingAccount(String accountNumber, double balance, String pin){
        super(accountNumber, balance, pin);
    }

    @Override
    public void deposit(double amount) {
        // Implementación de depósito...
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > getBalance()){
            throw new InsufficientFundsException();
        }
        // Lógica específica de retiro...
    }

}
