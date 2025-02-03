package com.example.leilao_produtos_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    private List<Bidding> biddings;

}





