package com.example.leilao_produtos_spring_boot.services.interfaces;

import com.example.leilao_produtos_spring_boot.models.User;

import java.util.List;

public interface UserManagment {

    public List<User> getAllUsers();

    public User getUserById(int id);

    public User createUser(User user);


}
