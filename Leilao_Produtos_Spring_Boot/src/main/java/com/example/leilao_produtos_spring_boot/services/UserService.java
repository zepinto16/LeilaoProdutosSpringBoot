package com.example.leilao_produtos_spring_boot.services;

import com.example.leilao_produtos_spring_boot.models.User;
import com.example.leilao_produtos_spring_boot.models.repository.UserRepository;
import com.example.leilao_produtos_spring_boot.services.interfaces.UserManagment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserManagment {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}

