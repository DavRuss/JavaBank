package ATM;

import Excepciones.InsufficientFundsException;
import Excepciones.InvalidAccountException;
import PatronComportamiento.Strategy.AuthStrategy;
import PatronEsctructural.Composite.Transaction;
import StreamReader.TransactionLogger;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ATM implements Authenticatable {
    private AuthStrategy authStrategy;
    private Calculadora calculator = new Calculadora();
//    private List<ATM.ATM.Account> accounts;
    private Map<String, Account> accounts;
    private static final String LOG_FILE = "transactions.log";
    private TransactionLogger logger = new TransactionLogger(LOG_FILE);


    public ATM() {
//        this.accounts = new ArrayList<>();
        accounts = new HashMap<>();
    }

    public void performTransfer(String sourceAccountNumber, String targetAccountNumber, double amount) {
        try {
            accounts.get(sourceAccountNumber).transferFunds(targetAccountNumber, amount);
            System.out.println("Transferencia exitosa");
        } catch (InsufficientFundsException | InvalidAccountException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Registro de la transacción
        }
        logger.logTransaction(sourceAccountNumber + " " + type + " " + amount);
    }

    public void addAccount(Account account) {
//        this.accounts.add(account);
    }

    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Bienvenido a JavaBank ATM.ATM.");
            System.out.println("Seleccione una operación:");
            System.out.println("1. Realizar una transacción");
            System.out.println("2. Usar la calculadora");
            System.out.println("0. Salir");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // lógica de transacción
                    break;
                case 2:
                    calculator.start();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Selección no válida.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        String accountNumber = null;
        System.out.println(accountNumber.length()); // Esto es una excepción unchecked ya que no se puede saber el .length() de un String nulo.
        ATM atm = new ATM();
        atm.start();
    }

    @Override
    public boolean authenticate(String pin) {
        // Lógica de autenticación...
        return true; // o false según el caso
    }

    public void setAuthStrategy(AuthStrategy authStrategy) {
        this.authStrategy = authStrategy;
    }

    public boolean authenticateUser(String data, String correctPIN) {
        return authStrategy.authenticate(data);
    }

    @Test
    void testATMTransaction() {
        ATM atm = new ATM();
        boolean authenticated = atm.authenticateUser("12345", "correctPIN");
        assertTrue(authenticated);

        atm.performTransaction("12345", Transaction.TransactionType.WITHDRAWAL, 100.00);
        assertEquals(400.00, atm.getAccountBalance("12345"));
    }


}

