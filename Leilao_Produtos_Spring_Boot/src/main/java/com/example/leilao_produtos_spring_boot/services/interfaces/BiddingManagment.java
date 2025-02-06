package com.example.leilao_produtos_spring_boot.services.interfaces;

import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.dto.BiddingRequestDTO;

import java.util.List;

public interface BiddingManagment {


    public List<Bidding> getAllBids();

    public Bidding getBiddingById(int id);

    public List<Bidding> getBidsByUser(int userId);

    public List<Bidding> getBidsByAuction(int auctionId) ;

    public Bidding placeBid(BiddingRequestDTO biddingRequestDTO);

}
