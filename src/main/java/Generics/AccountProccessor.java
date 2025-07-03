package Generics;

public class AccountProccessor implements Processable<Account> {
    public void process(Account account) {
        // Proceso de cuenta
    }

    public void processAccountList(AccountList<?> list) {
        // Proceso de lista de cuentas genéricas
    }
}