package com.example.leilao_produtos_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Classe que representa um leilão no sistema de leilão.
 * Utiliza JPA para persistência no banco de dados e Lombok para geração automática de métodos.
 */

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

    /**
     * Define o status do leilão.
     * Pode ser ACTIVE (ativo) ou CLOSED (encerrado).
     */
    @Enumerated(EnumType.STRING)
    private AuctionStatus status = AuctionStatus.ACTIVE;
}







