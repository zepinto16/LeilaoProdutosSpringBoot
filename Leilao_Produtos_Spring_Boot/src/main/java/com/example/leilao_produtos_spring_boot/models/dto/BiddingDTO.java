package com.example.leilao_produtos_spring_boot.models.dto;

import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BiddingDTO extends RepresentationModel<BiddingDTO> {

    private int id;

    private BigDecimal price;

    private LocalDateTime date;

    private User user;

    private Auction auction;


//    public static BiddingDTO toBiddingDTO(Bidding b){
//        return new BiddingDTO(b.getId(), b.getPrice(), b.getDate(), b.getUser(), b.getAuction());
//}
}
