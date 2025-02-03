package com.example.leilao_produtos_spring_boot.services.interfaces;
import com.example.leilao_produtos_spring_boot.models.Auction;

import java.util.List;

public interface AuctionManagment {

    public List<Auction> getAllAuctions();

    public Auction getAuctionById(int id);

    public Auction createAuction(Auction auction);
}
