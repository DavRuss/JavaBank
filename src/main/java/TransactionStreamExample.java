import PatronEsctructural.Composite.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class TransactionStreamExample {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("123", 100.00, Transaction.TransactionType.DEPOSIT));
        transactions.add(new Transaction("123", 50.00, Transaction.TransactionType.WITHDRAWAL));
        transactions.add(new Transaction("456", 75.00, Transaction.TransactionType.DEPOSIT));

        // Sumar todos los depósitos
        double totalDeposits = transactions.stream()
                .filter(t -> t.getType() == Transaction.TransactionType.DEPOSIT)
                .mapToDouble(Transaction::getAmount)
                .sum();
        System.out.println("Total Deposits: " + totalDeposits);

        // Encontrar la transacción con el mayor monto
        Transaction highestTransaction = transactions.stream()
                .max(Comparator.comparing(Transaction::getAmount))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Transacción con mayor monto: " + highestTransaction.getAmount());
    }
}


