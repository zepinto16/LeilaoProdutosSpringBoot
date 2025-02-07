package com.example.leilao_produtos_spring_boot.models.dto;

import lombok.*;

/**
 * DTO (Data Transfer Object) para representar uma solicitação de venda de um item no sistema de leilão.
 *
 * - Utilizado para receber os dados da requisição ao registrar uma venda.
 * - Evita expor diretamente a entidade Sale na API.
 */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class SaleRequestDTO {
        private int itemId; // Identificador do item que está a ser vendido
    }

