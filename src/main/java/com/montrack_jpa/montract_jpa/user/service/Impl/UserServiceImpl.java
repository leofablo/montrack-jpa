package com.montrack_jpa.montract_jpa.user.service.Impl;

import com.montrack_jpa.montract_jpa.user.entity.User;
import com.montrack_jpa.montract_jpa.user.repository.UserRepository;
import com.montrack_jpa.montract_jpa.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void createdUser(User user) {
        userRepository.save(user);

    }
}
