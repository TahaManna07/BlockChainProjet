package ma.enset.blockchain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.utils.HashUtil;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Block {
    private int index;
    private long timestamp;
    private String previousHash;
    private String hash;
    private String data;
    private int nonce;

    public Block(int index, String previousHash, String data) {
        this.index = index;
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public Block(int i, String string, String number, String genesisBlock, int i1) {
    }

    public String calculateHash() {
        return HashUtil.applySha256(index + previousHash + timestamp + data + nonce);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
    }
    // Getters and setters
    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public String getData() {
        return data;
    }

    public int getNonce() {
        return nonce;
    }

    // Getters and setters
    // ...
}

