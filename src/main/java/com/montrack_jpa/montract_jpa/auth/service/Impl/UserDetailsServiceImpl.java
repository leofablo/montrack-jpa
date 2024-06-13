package com.montrack_jpa.montract_jpa.auth.service.Impl;

import com.montrack_jpa.montract_jpa.auth.Entity.UserAuth;
import com.montrack_jpa.montract_jpa.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        var userData = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserAuth(userData);
    }


}
