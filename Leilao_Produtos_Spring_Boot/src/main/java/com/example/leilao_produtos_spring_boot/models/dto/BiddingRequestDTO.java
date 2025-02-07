package com.example.leilao_produtos_spring_boot.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DTO (Data Transfer Object) para a criação de uma nova licitação (lance).
 *
 * - Utilizado para receber os dados da requisição ao criar uma nova requesição.
 * - Evita expor diretamente a entidade Bidding na API.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BiddingRequestDTO {
    private int id; // Identificador da licitação (não precisa ser enviado na requisição)
    private int auctionId; // ID do leilão onde a licitação está a ser feita
    private int userId; // ID do utilizador que está a fazer a licitação
    private BigDecimal bidAmount; // Valor da licitação oferecida
}
