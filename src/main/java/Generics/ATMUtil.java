package Generics;

public class ATMUtil {
    public static <T> void printAccountDetails(T account) {
        System.out.println(account.toString());
    }

    public static <T extends Number> void showTransactionAmount(T amount) {
        System.out.println("Transaction amount: " + amount);
    }
}
