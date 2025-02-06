package com.example.leilao_produtos_spring_boot.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BiddingRequestDTO {
    private int id;
    private int auctionId;
    private int userId;
    private BigDecimal bidAmount;
}
