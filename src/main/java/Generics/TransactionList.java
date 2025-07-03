package Generics;

import java.util.ArrayList;
import java.util.List;

public class TransactionList<T> {
    private List<T> transactions = new ArrayList<>();

    public void addTransaction(T transaction) {
        transactions.add(transaction);
    }

    public T getTransaction(int index) {
        return transactions.get(index);
    }
}
