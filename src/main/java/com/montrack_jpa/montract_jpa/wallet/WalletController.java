package com.montrack_jpa.montract_jpa.wallet;

import com.montrack_jpa.montract_jpa.wallet.entity.Wallet;
import com.montrack_jpa.montract_jpa.wallet.service.WalletService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }

    @PostMapping
    public void createdWallet(@RequestBody Wallet wallet){
        walletService.createdWallet(wallet);

    }
}
