import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM implements Authenticatable{
    private Calculadora calculator = new Calculadora();
    private List<Account> accounts;

    public ATM() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
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
            System.out.println("Bienvenido a JavaBank ATM.");
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
        ATM atm = new ATM();
        atm.start();
    }

    @Override
    public boolean authenticate(String pin) {
        // Lógica de autenticación...
        return true; // o false según el caso
    }
}

