package com.montrack_jpa.montract_jpa.user.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.Instant;

@Setter
@Getter
@Entity
@Table(name = "users", schema = "montrack")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "avatar", nullable = false)
    private String avatar;

    @Column(name = "quote", nullable = false)
    private String quote;

    @Column(name = "created_at", nullable = false)
    private Instant createAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @Column(name = "is_deleted")
    private Instant isDeleted;



}
