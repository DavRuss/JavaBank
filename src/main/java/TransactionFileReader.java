import PatronEsctructural.Composite.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class TransactionFileReader {
    public static void main(String[] args) {
        String filePath = "transactions.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            Optional<Transaction> transaction = br.lines()
                    .map(line -> line.split(","))
                    .map(data -> new Transaction(data[0], Double.parseDouble(data[1]), Transaction.TransactionType.valueOf(data[2])))
                    .filter(t -> "123".equals(t.getAccountNumber()))
                    .findFirst();

            transaction.ifPresent(t -> System.out.println("Cuenta: " + t.getAccountNumber() + ", Monto: " + t.getAmount() + ", Tipo: " + t.getType()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

