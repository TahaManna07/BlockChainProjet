package ma.enset.blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blockchain;
    private int difficulty;

    public Blockchain(int difficulty) {
        this.blockchain = new ArrayList<>();
        this.difficulty = difficulty;
        // Create the genesis block
        Block genesisBlock = new Block(0, "0", "Genesis Block");
        genesisBlock.mineBlock(difficulty);
        blockchain.add(genesisBlock);
    }

    public void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
    }

    public Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    public boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    public List<Block> getBlockchain() {
        return blockchain;
    }
}
