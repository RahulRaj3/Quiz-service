package com.rahul.quiz_service.service;

import com.rahul.quiz_service.dao.UserRepository;
import com.rahul.quiz_service.model.MyUserDetails;
import com.rahul.quiz_service.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found" + username);
        }
        return new MyUserDetails(user);
    }
}
