package com.example.leilao_produtos_spring_boot.models.dto;

import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) para a entidade Bidding (Licitação/Lance).
 *
 * - Utilizado para retornar dados de um lance de forma estruturada na API.
 * - Evita expor diretamente a entidade Bidding na API.
 * - Suporta HATEOAS para adicionar links de navegação à resposta da API.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BiddingDTO extends RepresentationModel<BiddingDTO> {

    private int id; // Identificador da licitação

    private BigDecimal price; // Valor da licitação

    private LocalDateTime date; // Data e hora da licitação

    private User user; // Utilizador que fez a licitação

    private Auction auction; // Leilão onde a licitação foi feito


//    public static BiddingDTO toBiddingDTO(Bidding b){
//        return new BiddingDTO(b.getId(), b.getPrice(), b.getDate(), b.getUser(), b.getAuction());
//}
}
