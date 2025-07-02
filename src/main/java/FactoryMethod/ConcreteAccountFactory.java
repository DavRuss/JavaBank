package FactoryMethod;

public class ConcreteAccountFactory extends AccountFactory {

    @Override
    public Account createAccount(String accountType) {
        switch (accountType) {
            case "Savings":
                return new SavingsAccount();
            case "Checking":
                return new CheckingAccount();
            default:
                throw new IllegalArgumentException("Unknown account type");

        }
    }
}
