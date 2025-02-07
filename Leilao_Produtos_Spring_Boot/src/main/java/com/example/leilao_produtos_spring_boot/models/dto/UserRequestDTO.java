package com.example.leilao_produtos_spring_boot.models.dto;

import com.example.leilao_produtos_spring_boot.models.Gender;
import lombok.*;

/**
 * DTO (Data Transfer Object) para receber os dados ao criar ou atualizar um utilizador.
 *
 * - Utilizado para capturar os dados da requisição ao criar ou atualizar um utilizador.
 * - Evita expor diretamente a entidade User na API.
 * - Melhora a segurança e a organização dos dados recebidos.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserRequestDTO {
    private String name; // Nome do utilizador
    private int age; // Idade do utilizador
    private String email; // Endereço de e-mail do utilizador
    private Gender gender; // Género do utilizador
}

