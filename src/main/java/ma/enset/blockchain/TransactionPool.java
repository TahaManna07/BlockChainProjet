package ma.enset.blockchain;


import java.util.ArrayList;

public class TransactionPool {
    private ArrayList<Transaction> pendingTransactions;

    public TransactionPool() {
        this.pendingTransactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.pendingTransactions.add(transaction);
    }

    public ArrayList<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }

    public void removeTransaction(Transaction transaction) {
        this.pendingTransactions.remove(transaction);
    }
}
