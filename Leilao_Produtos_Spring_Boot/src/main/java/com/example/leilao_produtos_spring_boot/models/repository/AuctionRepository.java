package com.example.leilao_produtos_spring_boot.models.repository;

import com.example.leilao_produtos_spring_boot.models.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Integer> {
}
