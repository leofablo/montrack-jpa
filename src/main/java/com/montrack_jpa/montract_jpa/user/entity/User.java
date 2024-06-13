package com.montrack_jpa.montract_jpa.user.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.montrack_jpa.montract_jpa.auth.Entity.UserAuth;
import com.montrack_jpa.montract_jpa.wallet.entity.Wallet;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import java.time.Instant;

@Setter
@Getter
@Entity
@Table(name = "users", schema = "montrack")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "avatar", nullable = false)
    private String avatar;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private UserAuth userAuth;

    @Column(name = "quote", nullable = false)
    private String quote;

    @JsonIgnore
    @Size(max = 100)
    @OneToOne
    @Column(name = "hash", nullable = false, length = 100)
    private String password;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "selected_currency", nullable = false)
    private int activeCurrency;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @Column(name = "is_deleted")
    private Instant isDeleted;

    @PrePersist
    protected void onCreate() {
    createAt = Instant.now();
    updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "wallet_id", nullable = false)
//    private Wallet wallet;

}
