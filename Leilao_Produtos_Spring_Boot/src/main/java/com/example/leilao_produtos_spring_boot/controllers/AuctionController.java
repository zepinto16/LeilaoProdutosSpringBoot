package com.example.leilao_produtos_spring_boot.controllers;

import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.dto.AuctionRequestDTO;
import com.example.leilao_produtos_spring_boot.models.dto.BiddingRequestDTO;
import com.example.leilao_produtos_spring_boot.services.AuctionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auctions")
public class AuctionController {
    private final AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    /**
     * Criar um novo leilão
     */
    @PostMapping
    public Auction createAuction(@RequestBody AuctionRequestDTO auctionRequestDTO) {
        return auctionService.createAuction(auctionRequestDTO);
    }


    /**
     * Encerrar um leilão
     */
    @PostMapping("/close/{auctionId}")
    public void closeAuction(@PathVariable int auctionId) {
        auctionService.closeAuction(auctionId);
    }



    /**
     * Obter todas as licitações ativas
     */
    @GetMapping("/active-bids")
    public List<Bidding> getActiveBiddings() {
        return auctionService.getActiveBiddings();
    }


    @GetMapping("/active-auctions")
    public List<Auction> getAllActiveAuctions() {
        return auctionService.getAllActiveAuctions();
    }
}
