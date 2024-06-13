package com.montrack_jpa.montract_jpa.user.service.Impl;

import com.montrack_jpa.montract_jpa.user.dto.RegisterRequestDto;
import com.montrack_jpa.montract_jpa.user.entity.User;
import com.montrack_jpa.montract_jpa.user.repository.UserRepository;
import com.montrack_jpa.montract_jpa.user.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createdUser(User user) {
        userRepository.save(user);
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ApplicationContextException("User not found"));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ApplicationContextException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deletedById(long id) {

    }

    @Override
    public User profile() {
        return null;
    }

    @Override
    public User register() {
        return null;
    }

    @Override
    public User register(RegisterRequestDto user) {
        User newUser = user.toEntity();
        var password = passwordEncoder.encode(user.getPassword());
        newUser.setPassword(password);
        return userRepository.save(newUser);
    }




}
