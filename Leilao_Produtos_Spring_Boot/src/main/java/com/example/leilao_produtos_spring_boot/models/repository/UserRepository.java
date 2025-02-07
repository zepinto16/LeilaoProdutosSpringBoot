package com.example.leilao_produtos_spring_boot.models.repository;

import com.example.leilao_produtos_spring_boot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositório JPA para gerir operações de banco de dados relacionadas à entidade User (Utilizador).
 * Esta interface fornece métodos para procurar utilizadores com base em diferentes critérios.
 */
@Repository // Indica que esta interface é um componente Spring responsável pelo acesso ao banco de dados
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * Procura um utilizador pelo endereço de e-mail.
     *
     * @param email E-mail do utilizador a ser procurado.
     * @return Um Optional contendo o utilizador, caso ele exista no banco de dados.
     */
    Optional<User> findByEmail(String email);
}

