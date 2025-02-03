package com.example.leilao_produtos_spring_boot.models.repository;

import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiddingRepository extends JpaRepository<Bidding, Long> {

}
