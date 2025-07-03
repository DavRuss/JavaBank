package Generics;

import java.util.ArrayList;
import java.util.List;

public class AccountList<T> {
    private List<T> accounts = new ArrayList<>();

    public void addAccount(T account) {
        accounts.add(account);
    }

    public T getAccount(int index) {
        return accounts.get(index);
    }
}
