package com.example.leilao_produtos_spring_boot.controllers;

import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.dto.AuctionRequestDTO;
import com.example.leilao_produtos_spring_boot.models.dto.BiddingRequestDTO;
import com.example.leilao_produtos_spring_boot.services.AuctionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerir operações relacionadas aos leilões.
 *
 * - Permite criar, encerrar e listar leilões ativos.
 * - Permite buscar todas as licitações ativas.
 */
@RestController
@RequestMapping("api/auctions")
public class AuctionController {
    private final AuctionService auctionService; // Serviço responsável pela lógica dos leilões

    /**
     * Construtor que injeta o serviço AuctionService.
     */
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    /**
     * Criar um novo leilão.
     *
     * @param auctionRequestDTO Objeto DTO contendo os dados do novo leilão.
     * @return O leilão recém-criado.
     */
    @PostMapping
    public Auction createAuction(@RequestBody AuctionRequestDTO auctionRequestDTO) {
        return auctionService.createAuction(auctionRequestDTO);
    }


    /**
     * Encerrar um leilão.
     *
     * @param auctionId O ID do leilão que será encerrado.
     */
    @PostMapping("/close/{auctionId}")
    public void closeAuction(@PathVariable int auctionId) {
        auctionService.closeAuction(auctionId);
    }



   /**
     * Obter todas as licitações ativas (de leilões ainda em andamento).
     *
     * @return Lista de licitações associados a leilões ativos.
     */
    @GetMapping("/active-bids")
    public List<Bidding> getActiveBiddings() {
        return auctionService.getActiveBiddings();
    }


    /**
     * Obter todos os leilões ativos.
     *
     * @return Lista de leilões que ainda estão em andamento.
     */
    @GetMapping("/active-auctions")
    public List<Auction> getAllActiveAuctions() {
        return auctionService.getAllActiveAuctions();
    }
}
