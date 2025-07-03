import Excepciones.InsufficientFundsException;
import Excepciones.InvalidAccountException;
import PatronComportamiento.Observer.Observer;
import PatronEsctructural.Composite.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Authenticatable {
    private String accountNumber;
    private double balance;
    private String pin;
    private List<Observer> observers = new ArrayList<>();

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

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deposit(double amount){
        balance += amount;
        notifyObservers();
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if (balance < amount) {
            throw new InsufficientFundsException("Fondos insuficientes");
        }
        balance -= amount;
        notifyObservers();
    }

    public void performTransaction(String accountNumber, Transaction.TransactionType type, double amount) {
        try {
            if (type == Transaction.TransactionType.WITHDRAWAL) {
                accounts.get(accountNumber).withdraw(amount);
                System.out.println("Retiro exitoso");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Registro de la transacción
        }
    }

    public void transferFunds(String targetAccountNumber, double amount)
            throws InsufficientFundsException, InvalidAccountException {
        if (balance < amount) {
            throw new InsufficientFundsException("Fondos insuficientes");
        }
        if (!Bank.isValidAccount(targetAccountNumber)) {
            throw new InvalidAccountException("Cuenta destino no válida");
        }
        balance -= amount;
        Bank.getAccount(targetAccountNumber).deposit(amount);
    }

    @Override
    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }

    public void mostrarSaldo() {
        System.out.println("Saldo actual: " + this.balance);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(balance);
        }
    }

}

