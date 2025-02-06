package com.example.leilao_produtos_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "auction_id", nullable = false)
    private Auction auction;

    private int itemId;

    public Bidding(BigDecimal bidAmount, LocalDateTime now, User user, Auction auction, int auctionId) {
    }


    //public Bidding(BigDecimal price, LocalDateTime now, User user, Auction auction) {    }
}
