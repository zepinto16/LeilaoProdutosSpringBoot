package com.example.leilao_produtos_spring_boot.controllers;

import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.dto.BiddingRequestDTO;
import com.example.leilao_produtos_spring_boot.services.BiddingService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/biddings")
public class BiddingController {

    private final BiddingService biddingService;

    public BiddingController(BiddingService biddingService) {
        this.biddingService = biddingService;
    }

    /**
     * Obtém todas as licitações cadastradas
     */
    @GetMapping
    public List<Bidding> getAllBids() {
        return biddingService.getAllBids();
    }

    /**
     * Obtém uma licitação específica pelo ID
     */
    @GetMapping("/{id}")
    public Bidding getBiddingById(@PathVariable int id) {
        return biddingService.getBiddingById(id);
    }

    /**
     * Obtém todas as licitações feitas por um usuário específico
     */
    @GetMapping("/user/{userId}")
    public List<Bidding> getBidsByUser(@PathVariable int userId) {
        return biddingService.getBidsByUser(userId);
    }

    /**
     * Obtém todas as licitações para um leilão específico
     */
    @GetMapping("/auction/{auctionId}")
    public List<Bidding> getBidsByAuction(@PathVariable int auctionId) {
        return biddingService.getBidsByAuction(auctionId);
    }

    /**
     * Criar uma nova licitação
     */
    @PostMapping("/")
        public Bidding placeBid(@RequestBody BiddingRequestDTO biddingRequestDTO) {
        return biddingService.placeBid(biddingRequestDTO);
    }


}

