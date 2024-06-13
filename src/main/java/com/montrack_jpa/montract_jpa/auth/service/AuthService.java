package com.montrack_jpa.montract_jpa.auth.service;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;

public interface AuthService {
    String generateToken(Authentication authentication);
}
