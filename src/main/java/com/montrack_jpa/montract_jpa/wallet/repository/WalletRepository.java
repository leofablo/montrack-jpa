package com.montrack_jpa.montract_jpa.wallet.repository;

import com.montrack_jpa.montract_jpa.wallet.entity.Wallet;
import org.springframework.jdbc.core.JdbcTemplate;

public class WalletRepository {

    private JdbcTemplate jdbcTemplate;

    public WalletRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Wallet wallet){
        String sql = "INSERT INTO montrack.wallet (name, balance, user_id, currency_id, created_at, updated_at, deleted_at) VALUES (?, ?, ?, ?, NOW(), NOW(), NULL)";
        jdbcTemplate.update(sql, wallet.getName(), wallet.getUser(), wallet.getId(), wallet.getBalance());
    }
}
