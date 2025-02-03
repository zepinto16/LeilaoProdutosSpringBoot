package com.example.leilao_produtos_spring_boot.services;

import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.repository.AuctionRepository;
import com.example.leilao_produtos_spring_boot.services.interfaces.AuctionManagment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService implements AuctionManagment {

    @Autowired
    private final AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction getAuctionById(int id) {
        return auctionRepository.findById(id).orElse(null);
    }

    @Override
    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }
}

