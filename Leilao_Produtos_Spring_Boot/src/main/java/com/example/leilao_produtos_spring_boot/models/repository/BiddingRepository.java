package com.example.leilao_produtos_spring_boot.models.repository;

import com.example.leilao_produtos_spring_boot.models.AuctionStatus;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BiddingRepository extends JpaRepository<Bidding, Integer> {

    List<Bidding> findByUserId(int userId);
    List<Bidding> findByAuctionId(int auctionId);

    @Query("SELECT MAX(b.price) FROM Bidding b WHERE b.auction.id = :auctionId")
    BigDecimal findHighestBidByAuctionId(int auctionId);

    @Query("SELECT b FROM Bidding b WHERE b.auction.status = :status")
    List<Bidding> findBiddingsByAuctionStatus(AuctionStatus status);
}
