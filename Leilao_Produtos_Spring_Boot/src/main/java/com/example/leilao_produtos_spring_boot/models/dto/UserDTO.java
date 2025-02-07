package com.example.leilao_produtos_spring_boot.models.dto;

import com.example.leilao_produtos_spring_boot.models.Gender;
import com.example.leilao_produtos_spring_boot.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

/**
 * DTO (Data Transfer Object) para a entidade User (Usuário).
 *
 * - Utilizado para transferir os dados do usuário entre a API e o sistema.
 * - Evita expor diretamente a entidade User na API.
 * - Suporta HATEOAS para permitir a adição de links na resposta da API.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO extends RepresentationModel<UserDTO> {

    private int id; // Identificador único do usuário

    String name; // Nome do utilizador

    private int age; // Idade do utilizador

    private String email; // E-mail do utilizador

    private Gender gender; // Género do utilizador

    /**
     * Método estático para converter uma entidade User em um UserDTO.
     *
     * @param u Objeto User a ser convertido.
     * @return Objeto UserDTO contendo os mesmos dados do utilizador original.
     */
    public static UserDTO toUserDTO(User u){
        return new UserDTO(u.getId(), u.getName(), u.getAge(), u.getEmail(), u.getGender());
    }

}
