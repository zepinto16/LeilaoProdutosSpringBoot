package com.example.leilao_produtos_spring_boot.models.dto;

import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

/**
 * DTO (Data Transfer Object) para a entidade Auction (Leilão).
 *
 * - Evita expor diretamente a entidade Auction na API.
 * - Utiliza o padrão HATEOAS para fornecer links de navegação na API.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuctionDTO extends RepresentationModel<AuctionDTO> {

    private int id; // Identificador do leilão

    private String name; // Nome do leilão

    private String description; // Descrição do leilão

    private List<Bidding> biddings; // Lista de licitações associadas ao leilão

    /**
     * Método estático para converter uma entidade Auction em um AuctionDTO.
     *
     * @param a Objeto Auction a ser convertido.
     * @return Objeto AuctionDTO contendo os mesmos dados do leilão original.
     */
    public static AuctionDTO toAuctionDTO(Auction a) {
        return new AuctionDTO(a.getId(), a.getName(), a.getDescription(), null);
    }
}
