package com.example.leilao_produtos_spring_boot.services;

import com.example.leilao_produtos_spring_boot.exceptions.InvalidUserDataException;
import com.example.leilao_produtos_spring_boot.exceptions.UserAlreadyExistsException;
import com.example.leilao_produtos_spring_boot.exceptions.UserNotFoundException;
import com.example.leilao_produtos_spring_boot.models.User;
import com.example.leilao_produtos_spring_boot.models.dto.UserRequestDTO;
import com.example.leilao_produtos_spring_boot.models.repository.UserRepository;
import com.example.leilao_produtos_spring_boot.services.interfaces.UserManagment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User createUser(UserRequestDTO userRequestDTO) {

        if (userRequestDTO.getName() == null || userRequestDTO.getName().trim().isEmpty()) {
            throw new InvalidUserDataException("O nome do usuário não pode estar vazio.");
        }

        if (userRequestDTO.getEmail() == null || !userRequestDTO.getEmail().contains("@")) {
            throw new InvalidUserDataException("E-mail inválido.");
        }

        if (userRequestDTO.getAge() <= 0) {
            throw new InvalidUserDataException("A idade deve ser maior que zero.");
        }


        Optional<User> existingUser = userRepository.findByEmail(userRequestDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("E-mail já cadastrado.");
        }


        User newUser = new User();
        newUser.setName(userRequestDTO.getName());
        newUser.setEmail(userRequestDTO.getEmail());
        newUser.setAge(userRequestDTO.getAge());
        newUser.setGender(userRequestDTO.getGender());

        return userRepository.save(newUser);
    }
    /**
     * Atualizar um usuário pelo ID
     */
    public User updateUser(int id, UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
        existingUser.setName(userRequestDTO.getName());
        existingUser.setAge(userRequestDTO.getAge());
        existingUser.setEmail(userRequestDTO.getEmail());
        existingUser.setGender(userRequestDTO.getGender());
        return userRepository.save(existingUser);
    }

    /**
     * Deletar um usuário pelo ID
     */
    public void deleteUser(int id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
        userRepository.delete(existingUser);
    }
}



