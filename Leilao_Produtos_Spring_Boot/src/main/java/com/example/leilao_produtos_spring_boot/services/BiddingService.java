package com.example.leilao_produtos_spring_boot.services;

import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.User;
import com.example.leilao_produtos_spring_boot.models.dto.BiddingRequestDTO;
import com.example.leilao_produtos_spring_boot.models.repository.AuctionRepository;
import com.example.leilao_produtos_spring_boot.models.repository.BiddingRepository;
import com.example.leilao_produtos_spring_boot.models.repository.UserRepository;
import com.example.leilao_produtos_spring_boot.services.interfaces.BiddingManagment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BiddingService implements BiddingManagment {

    private final BiddingRepository biddingRepository;
    private final AuctionRepository auctionRepository;
    private final UserRepository userRepository;


    public BiddingService(BiddingRepository biddingRepository, AuctionRepository auctionRepository, UserRepository userRepository ) {
        this.biddingRepository = biddingRepository;
        this.auctionRepository = auctionRepository;
        this.userRepository = userRepository;
    }

    public List<Bidding> getAllBids() {
        return biddingRepository.findAll();
    }

    public Bidding getBiddingById(int id) {
        return biddingRepository.findById(id).orElse(null);
    }

    public List<Bidding> getBidsByUser(int userId) {
        return biddingRepository.findByUserId(userId);
    }

    public List<Bidding> getBidsByAuction(int auctionId) {
        return biddingRepository.findByAuctionId(auctionId);
    }

    public Bidding placeBid(BiddingRequestDTO biddingRequestDTO) {

        Optional<User> userOpt = userRepository.findById(biddingRequestDTO.getUserId());
        Optional<Auction> auctionOpt = auctionRepository.findById(biddingRequestDTO.getAuctionId());

        if (userOpt.isEmpty() || auctionOpt.isEmpty()) {
            throw new RuntimeException("User ou leilão não encontrado.");
        }

        User user = userOpt.get();
        Auction auction = auctionOpt.get();


        BigDecimal highestBid = biddingRepository.findHighestBidByAuctionId(biddingRequestDTO.getAuctionId());


        if (highestBid != null && biddingRequestDTO.getBidAmount().compareTo(highestBid) <= 0) {
            throw new RuntimeException("O lance deve ser maior que o maior lance atual.");
        }


        Bidding newBid = new Bidding();
        newBid.setDate(LocalDateTime.now());
        newBid.setPrice(biddingRequestDTO.getBidAmount());
        newBid.setUser(user);
        newBid.setAuction(auction);

        return biddingRepository.save(newBid);

    }
}

