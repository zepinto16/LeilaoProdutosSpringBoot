package com.example.leilao_produtos_spring_boot.controllers;

import com.example.leilao_produtos_spring_boot.models.User;
import com.example.leilao_produtos_spring_boot.models.dto.UserRequestDTO;
import com.example.leilao_produtos_spring_boot.services.UserService;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);

    }

    /**
     * Buscar um usuário pelo ID
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    /**
     * Atualizar um usuário pelo ID
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(id, userRequestDTO);
    }

    /**
     * Deletar um usuário pelo ID
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User apagado com sucesso!";
    }
}



