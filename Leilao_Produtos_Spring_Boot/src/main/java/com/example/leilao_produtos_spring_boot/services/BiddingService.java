package com.example.leilao_produtos_spring_boot.services;

import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.repository.BiddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiddingService {

    @Autowired
    private final BiddingRepository biddingRepository;

    public BiddingService(BiddingRepository biddingRepository) {
        this.biddingRepository = biddingRepository;
    }

    public List<Bidding> getAllBids() {
        return biddingRepository.findAll();
    }

    public Bidding placeBid(Bidding bidding) {
        return biddingRepository.save(bidding);
    }
}

