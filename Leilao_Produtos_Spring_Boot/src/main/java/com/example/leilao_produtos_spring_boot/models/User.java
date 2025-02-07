package com.example.leilao_produtos_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Classe que representa um utilizador no sistema de leilão.
 * Utiliza JPA para mapeamento da entidade e Lombok para gerar métodos automaticamente.
 */

@Entity(name = "Leilao_user") // Define que esta classe é uma entidade JPA e será mapeada para a tabela "Leilao_user"
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class User {
    @Id // Define que este campo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz com que o ID seja gerado automaticamente pelo banco de dados
    private int id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
