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

public class PendentItemResponseDTO {


    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private String categoryName;

}