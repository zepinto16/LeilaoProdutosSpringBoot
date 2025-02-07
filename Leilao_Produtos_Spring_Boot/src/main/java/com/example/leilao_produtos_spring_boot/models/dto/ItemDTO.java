package com.example.leilao_produtos_spring_boot.models.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DTO (Data Transfer Object) para a entidade Item.
 *
 * - Utilizado para transferir os dados do item entre a API e o sistema.
 * - Evita expor diretamente a entidade Item na API.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private int id; // Identificador único do item
    private String name; // Nome do item leiloado
    private String description; // Descrição do item
    private BigDecimal price; // Preço inicial do item no leilão
}
