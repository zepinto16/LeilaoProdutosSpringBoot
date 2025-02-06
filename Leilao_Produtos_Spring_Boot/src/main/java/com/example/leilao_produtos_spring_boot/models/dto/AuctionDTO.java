package com.example.leilao_produtos_spring_boot.models.dto;

import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuctionDTO extends RepresentationModel<AuctionDTO> {

    private int id;

    private String name;

    private String description;

    private List<Bidding> biddings;


    public static AuctionDTO toAuctionDTO(Auction a) {
        return new AuctionDTO(a.getId(), a.getName(), a.getDescription(), null);
    }
}
