package com.montrack_jpa.montract_jpa.wallet.entity;


import com.montrack_jpa.montract_jpa.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;


@Setter
@Getter
@Entity
@Data
@Table(name = "wallet", schema = "montrack")
public class Wallet {

    @Id
    @ColumnDefault("0")
    @Column(name = "id", nullable = false)
    private Long id;

    @ColumnDefault("0")
    @Column(name = "balance", nullable = false, precision = 10, scale = 5)
    private BigDecimal balance;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "deleted_at", nullable = false)
    private Instant deletedAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    @PrePersist
    protected void onCreate(){
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = Instant.now();
    }






}
