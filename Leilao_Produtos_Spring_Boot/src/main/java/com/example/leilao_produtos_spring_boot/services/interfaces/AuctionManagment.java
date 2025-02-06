package com.example.leilao_produtos_spring_boot.services.interfaces;
import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.AuctionStatus;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.dto.AuctionRequestDTO;
import com.example.leilao_produtos_spring_boot.models.dto.BiddingRequestDTO;

import java.util.List;

public interface AuctionManagment {

    public Auction createAuction(AuctionRequestDTO auctionRequestDTO);

    public void closeAuction(int auctionId);

    public List<Auction> getAllActiveAuctions();

    public List<Bidding> getActiveBiddings();


}



