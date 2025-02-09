package com.igomarcelino.treinando_jwt.service;

import com.igomarcelino.treinando_jwt.Repoositories.UserRepository;
import com.igomarcelino.treinando_jwt.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByUserLogin(String userLogin){
        var user = userRepository.findByUserLogin(userLogin);
        return user.get();
    }

    public User findById(Integer id){
        return userRepository.findById(id).get();
    }
}
