package ma.enset.services;
import lombok.Data;
import ma.enset.blockchain.Block;
import ma.enset.blockchain.Blockchain;
import ma.enset.blockchain.Transaction;
import ma.enset.blockchain.TransactionPool;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlockchainService {

    private List<Block> blockchain = new ArrayList<>();
    private List<Transaction> pendingTransactions = new ArrayList<>();
    private int difficulty = 4;

    public BlockchainService() {
        blockchain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {
        return new Block(0, new Date().toString(), "0", "Genesis Block", 0);
    }

    public List<Block> getBlockchain() {
        return blockchain;
    }

    public Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    public void addTransaction(Transaction transaction) {
        pendingTransactions.add(transaction);
    }

    public Block mineBlock(Transaction transaction) {
        addTransaction(transaction);
        String previousHash = getLatestBlock().getHash();
        Block newBlock = new Block(blockchain.size(), new Date().toString(), previousHash, pendingTransactions.toString(), 0);
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
        pendingTransactions.clear();
        return newBlock;
    }

    public boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }

        return true;
    }
}
