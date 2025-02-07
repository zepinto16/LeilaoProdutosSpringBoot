package com.example.leilao_produtos_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * * Classe que representa uma licitação num leilão.
 *  * Utiliza JPA para persistência no banco de dados e Lombok para geração automática de métodos.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Bidding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private BigDecimal price;

    @NonNull
    private LocalDateTime date;

    /**
     * Relacionamento com a entidade User (Utilizador que fez a licitação).
     * Muitas licitações podem ser feitos por um mesmo utilizador.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Relacionamento com a entidade Auction (Leilão onde a licitação foi feita).
     * Muitas licitações podem estar associados a um mesmo leilão.
     */
    @ManyToOne
    @JoinColumn(name = "auction_id", nullable = false)
    private Auction auction;

    /**
     * ID do item leiloado (se aplicável).
     * Esse campo pode ser útil se cada licitação estiver vinculada a um item específico dentro de um leilão.
     */
    private int itemId;

    /**
     * Construtor personalizado para criar uma licitação.
     * Não inicializa os atributos corretamente, pois está vazio.
     */
    public Bidding(BigDecimal bidAmount, LocalDateTime now, User user, Auction auction, int auctionId) {
    }


    //public Bidding(BigDecimal price, LocalDateTime now, User user, Auction auction) {    }
}
