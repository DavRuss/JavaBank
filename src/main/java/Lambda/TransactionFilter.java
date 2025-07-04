package Lambda;

import PatronEsctructural.Composite.Transaction;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface TransactionFilter {
    boolean filter(Transaction transaction);

    TransactionFilter highValueTransactions = t -> t.getAmount() > 1000;

    List<Transaction> transactions = // inicializar con transacciones;
            List<Transaction> highValueList = transactions.stream()
                    .filter(highValueTransactions::filter)
                    .collect(Collectors.toList());

    TransactionFilter deposits = t -> t.getType() == Transaction.TransactionType.DEPOSIT;
    TransactionFilter withdrawals = t -> t.getType() == Transaction.TransactionType.WITHDRAWAL;

    List<Transaction> depositList = transactions.stream()
            .filter(deposits::filter)
            .collect(Collectors.toList());

    List<Transaction> withdrawalList = transactions.stream()
            .filter(withdrawals::filter)
            .collect(Collectors.toList());


}


