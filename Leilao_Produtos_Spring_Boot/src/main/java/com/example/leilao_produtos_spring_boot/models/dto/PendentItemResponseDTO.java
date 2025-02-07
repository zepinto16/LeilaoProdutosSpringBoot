package com.example.leilao_produtos_spring_boot.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DTO (Data Transfer Object) para representar itens pendentes no sistema de leilão.
 *
 * - Utilizado para transferir os dados dos itens pendentes entre a API e o sistema.
 * - Evita expor diretamente a entidade Item na API.
 * - Inclui informações sobre a categoria do item.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PendentItemResponseDTO {


    private int id; // Identificador único do item pendente
    private String name; // Nome do item pendente
    private String description; // Descrição detalhada do item
    private BigDecimal price; // Preço do item no leilão
    private String categoryName; // Nome da categoria à qual o item pertence

}
