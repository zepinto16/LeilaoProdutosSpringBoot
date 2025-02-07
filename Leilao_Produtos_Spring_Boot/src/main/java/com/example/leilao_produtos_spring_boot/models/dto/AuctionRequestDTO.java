package com.example.leilao_produtos_spring_boot.models.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO (Data Transfer Object) para criar um novo leilão (Auction).
 *
 * - Utilizado para receber os dados da requisição ao criar um novo leilão.
 * - Evita expor diretamente a entidade Auction na API.
 */
@Getter
@Setter
public class AuctionRequestDTO {
    private String name; // Nome do leilão
    private String description; // Descrição do leilão
}
