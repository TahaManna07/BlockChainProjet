package ma.enset.controller;

import ma.enset.blockchain.Block;
import ma.enset.blockchain.Transaction;
import ma.enset.services.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;



@RestController
@RequestMapping("/api/blockchain")
@CrossOrigin("*")
public class BlockchainController {

    @Autowired
    private BlockchainService blockchainService;

    @GetMapping("/blocks")
    public List<Block> getBlocks() {
        return blockchainService.getBlockchain();
    }

    @PostMapping("/mine")
    public Block mineBlock(@RequestBody Transaction transaction) {
        return blockchainService.mineBlock(transaction);
    }

    @GetMapping("/isValid")
    public boolean isChainValid() {
        return blockchainService.isChainValid();
    }
}
