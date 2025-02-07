package com.example.leilao_produtos_spring_boot.controllers;

import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.dto.BiddingRequestDTO;
import com.example.leilao_produtos_spring_boot.services.BiddingService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Controlador REST para gerir operações relacionadas às licitações.
 *
 * - Permite criar, buscar e listar licitações de utilizadores ou leilões.
 */
@RestController
@RequestMapping("/api/biddings")
public class BiddingController {

    private final BiddingService biddingService; // Serviço responsável pela lógica das licitações

    /**
     * Construtor que injeta o serviço BiddingService.
     */
    public BiddingController(BiddingService biddingService) {
        this.biddingService = biddingService;
    }

    /**
     * Obtém todas as licitações cadastradas.
     *
     * @return Lista de todas as licitações registradas no sistema.
     */
    @GetMapping
    public List<Bidding> getAllBids() {
        return biddingService.getAllBids();
    }

    /**
     * Obtém uma licitação específica pelo ID.
     *
     * @param id O ID da licitação desejada.
     * @return O objeto Bidding correspondente ao ID informado.
     */
    @GetMapping("/{id}")
    public Bidding getBiddingById(@PathVariable int id) {
        return biddingService.getBiddingById(id);
    }

    /**
     * Obtém todas as licitações feitas por um utilizador específico.
     *
     * @param userId O ID do utilizador cujas licitações serão buscados.
     * @return Lista de licitações feitos pelo utilizador.
     */
    @GetMapping("/user/{userId}")
    public List<Bidding> getBidsByUser(@PathVariable int userId) {
        return biddingService.getBidsByUser(userId);
    }

    /**
     * Obtém todas as licitações para um leilão específico.
     *
     * @param auctionId O ID do leilão cujas licitações serão buscados.
     * @return Lista de licitações dentro do leilão especificado.
     */
    @GetMapping("/auction/{auctionId}")
    public List<Bidding> getBidsByAuction(@PathVariable int auctionId) {
        return biddingService.getBidsByAuction(auctionId);
    }

    /**
     * Criar uma nova licitação.
     *
     * @param biddingRequestDTO Objeto DTO contendo os dados da licitação.
     * @return O objeto Bidding recém-criado.
     */
    @PostMapping("/")
        public Bidding placeBid(@RequestBody BiddingRequestDTO biddingRequestDTO) {
        return biddingService.placeBid(biddingRequestDTO);
    }


}

