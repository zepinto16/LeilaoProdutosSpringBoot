package com.example.leilao_produtos_spring_boot.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuctionRequestDTO {
    private String name;
    private String description;
}