package com.montrack_jpa.montract_jpa.user.service;


import com.montrack_jpa.montract_jpa.user.dto.RegisterRequestDto;
import com.montrack_jpa.montract_jpa.user.entity.User;

import java.util.List;

public interface UserService {

    void createdUser(User user);
    User register(RegisterRequestDto user);
    User findByEmail(String email);
    User findById(Long id);
    List<User> findAll();
    void deletedById(long id);
    User profile();

    User register();
}
