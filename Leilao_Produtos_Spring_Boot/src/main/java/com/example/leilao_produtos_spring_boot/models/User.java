package com.example.leilao_produtos_spring_boot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
    int id;
    @NonNull
    String name;
    @NonNull
    int age;
    @NonNull
    String email;
    @NotNull
    @Enumerated
    Gender gender;
}
