package PatronEsctructural.Composite;

public interface Transaction {
    Object TransactionType = ;

    void execute();

    boolean getType();

    int getAmount();
}
