package ATM;

import Excepciones.InsufficientFundsException;
import Excepciones.InvalidAccountException;
import PatronComportamiento.Observer.Observer;
import PatronEsctructural.Composite.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class Account implements Authenticatable {
    private String accountNumber;
    private double balance;
    private String pin;
    private List<Observer> observers = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(ATM.class.getName());

    public Account(String accountNumber, double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = pin;
    }

    public Account() {

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
        System.out.println("Depositing: " + amount); // Mensaje para depuración
        if (balance < amount) {
            throw new InsufficientFundsException("Fondos insuficientes");
        }
        balance -= amount;
        notifyObservers();
    }

    public void performTransaction(String accountNumber, Transaction.TransactionType type, double amount) {
        logger.info("Initiating transaction for account: " + accountNumber);
        try {
            if (type == Transaction.TransactionType.WITHDRAWAL) {
                accounts.get(accountNumber).withdraw(amount);
                System.out.println("Retiro exitoso");
                logger.info("Transaction completed successfully.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
            logger.severe("Transaction failed: " + e.getMessage());
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

    public boolean authenticateUser(String inputPin) {
        int attempts = 0;
        while (attempts < 3) {
            if (this.pin.equals(inputPin)) { // Coloca un breakpoint aquí
                return true;
            } else {
                attempts++;
                System.out.println("PIN incorrecto. Intento " + attempts + " de 3.");
            }
        }
        return false;
    }


}

