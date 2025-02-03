package com.example.leilao_produtos_spring_boot.models.dto;

import com.example.leilao_produtos_spring_boot.models.Gender;
import com.example.leilao_produtos_spring_boot.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO extends RepresentationModel<UserDTO> {

    private int id;

    String name;

    private int age;

    private String email;

    private Gender gender;

    public static UserDTO toUserDTO(User u){
        return new UserDTO(u.getId(), u.getName(), u.getAge(), u.getEmail(), u.getGender());
    }

}
