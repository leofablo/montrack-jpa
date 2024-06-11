package com.montrack_jpa.montract_jpa.wallet.service.Impl;

import com.montrack_jpa.montract_jpa.wallet.entity.Wallet;
import com.montrack_jpa.montract_jpa.wallet.repository.WalletRepository;
import com.montrack_jpa.montract_jpa.wallet.service.WalletService;
import org.springframework.stereotype.Service;


@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    @Override
    public void createdWallet(Wallet wallet){
        walletRepository.save(wallet);


    }
}
