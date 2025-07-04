package FactoryMethod;

import ATM.Account;

public abstract class AccountFactory {
    public abstract Account createAccount(String accountType);
}
