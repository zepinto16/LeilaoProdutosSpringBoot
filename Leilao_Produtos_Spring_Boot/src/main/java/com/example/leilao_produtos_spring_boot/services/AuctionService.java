package com.example.leilao_produtos_spring_boot.services;

import com.example.leilao_produtos_spring_boot.exceptions.InvalidAuctionDataException;
import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.AuctionStatus;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.dto.AuctionRequestDTO;
import com.example.leilao_produtos_spring_boot.models.repository.AuctionRepository;
import com.example.leilao_produtos_spring_boot.models.repository.BiddingRepository;
import com.example.leilao_produtos_spring_boot.models.repository.UserRepository;
import com.example.leilao_produtos_spring_boot.services.interfaces.AuctionManagment;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService implements AuctionManagment {

    private final AuctionRepository auctionRepository;
    private final BiddingRepository biddingRepository;


    public AuctionService(AuctionRepository auctionRepository, BiddingRepository biddingRepository, UserRepository userRepository) {
        this.auctionRepository = auctionRepository;
        this.biddingRepository = biddingRepository;

    }

    /**
     * Criar um novo leilão
     */
    public Auction createAuction(AuctionRequestDTO auctionRequestDTO) {
        // Validação dos dados do leilão
        if (auctionRequestDTO.getName() == null || auctionRequestDTO.getName().trim().isEmpty()) {
            throw new InvalidAuctionDataException("O nome do leilão não pode estar vazio.");
        }

        if (auctionRequestDTO.getDescription() == null || auctionRequestDTO.getDescription().trim().isEmpty()) {
            throw new InvalidAuctionDataException("A descrição do leilão não pode estar vazia.");
        }

        // Criar e salvar o leilão
        Auction newAuction = new Auction(auctionRequestDTO.getName(), auctionRequestDTO.getDescription());
        return auctionRepository.save(newAuction);
    }

    /**
     * Encerrar um leilão
     */
    @Transactional
    public void closeAuction(int auctionId) {
        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new RuntimeException("Leilão não encontrado"));

        auction.setStatus(AuctionStatus.CLOSED);
        auctionRepository.save(auction); // Atualiza o leilão no banco de dados
    }

    /**
     * Obter todos os leilões ativos
     */
    public List<Auction> getAllActiveAuctions() {
        return auctionRepository.findByStatus(AuctionStatus.ACTIVE);
    }


    /**
     * Obter todas as licitações ativas (de leilões ainda em andamento)
     */
    public List<Bidding> getActiveBiddings() {
        return biddingRepository.findBiddingsByAuctionStatus(AuctionStatus.ACTIVE);
    }
}
