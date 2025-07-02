import PatronComportamiento.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Authenticatable {
    private String accountNumber;
    private double balance;
    private String pin;
    private List<Observer> observers = new ArrayList<>();
    private double balance;

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

    public abstract void deposit(double amount);
//    balance += amount;
//    notifyObservers();
    public abstract void withdraw(double amount) throws InsufficientFundsException;
//    balance -= amount;
//    notifyObservers();
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

