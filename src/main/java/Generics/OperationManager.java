package Generics;

import java.util.ArrayList;
import java.util.List;

public class OperationManager<D, W> {
    private List<D> depositOperations = new ArrayList<>();
    private List<W> withdrawalOperations = new ArrayList<>();

    public void addDepositOperation(D deposit) {
        depositOperations.add(deposit);
    }

    public void addWithdrawalOperation(W withdrawal) {
        withdrawalOperations.add(withdrawal);
    }

    public List<D> getAllDepositOperations() {
        return new ArrayList<>(depositOperations);
    }

    public List<W> getAllWithdrawalOperations() {
        return new ArrayList<>(withdrawalOperations);
    }
}
