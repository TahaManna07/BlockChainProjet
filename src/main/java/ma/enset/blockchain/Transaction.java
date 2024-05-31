package ma.enset.blockchain;


public class Transaction {
    private String sender;
    private String recipient;
    private float amount;

    public Transaction(String sender, String recipient, float amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public float getAmount() {
        return amount;
    }
}
