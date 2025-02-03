package com.example.leilao_produtos_spring_boot.services.interfaces;

import com.example.leilao_produtos_spring_boot.models.Bidding;

import java.util.List;

public interface BiddingManagment {


    public List<Bidding> getAllBids();

    public Bidding placeBid(Bidding bidding);

}
