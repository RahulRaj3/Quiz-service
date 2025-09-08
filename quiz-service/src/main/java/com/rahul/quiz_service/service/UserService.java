package com.rahul.quiz_service.service;

import com.rahul.quiz_service.dao.UserRepository;
import com.rahul.quiz_service.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    public String authenticateUser(Users user) {
       Users user1 = userRepository.findByUserName(user.getUserName());
       if(user1==null){
           throw new UsernameNotFoundException("Username not found");
       }
       if(!user1.getPassword().equals(user.getPassword())) {
           throw  new UsernameNotFoundException("Incorrect password");
       }
       return "User authenticated Successfully";
    }
}
