package com.example.leilao_produtos_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    private int id;
    @NonNull
    String name;
    @NonNull
    private int age;
    @NonNull
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
