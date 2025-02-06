package com.example.leilao_produtos_spring_boot;

import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.Gender;
import com.example.leilao_produtos_spring_boot.models.User;
import com.example.leilao_produtos_spring_boot.models.repository.AuctionRepository;
import com.example.leilao_produtos_spring_boot.models.repository.BiddingRepository;
import com.example.leilao_produtos_spring_boot.models.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class dataloader implements CommandLineRunner {

    private final AuctionRepository auctionRepository;
    private final BiddingRepository biddingRepository;
    private final UserRepository userRepository;

    public dataloader(AuctionRepository auctionRepository, BiddingRepository biddingRepository, UserRepository userRepository) {
        this.auctionRepository = auctionRepository;
        this.biddingRepository = biddingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Criar usuários
        User user1 = new User("José Silva", 30, "jose@email.com");
        User user2 = new User("Ana Oliveira", 28, "anaoliveira@email.com");
        User user3 = new User("Carla Pinto", 35, "carlapinto@email.com");
        User user4 = new User("Ana Pereira", 27, "ana@email.com");
        User user5 = new User("Fernando Lima", 40, "fernando@email.com");
        userRepository.saveAll(List.of(user1, user2, user3, user4, user5));

        // Criar leilões
        Auction auction1 = new Auction("Leilão de Vestidos", "Leilão de vestidos usados");
        Auction auction2 = new Auction("Leilão de Roupa", "Leilão de fatos e camisas");
        Auction auction3 = new Auction("Leilão de Imóveis", "Leilão de propriedades e terrenos");
        Auction auction4 = new Auction("Leilão de Relógios", "Leilão de relógios de luxo");

        auctionRepository.saveAll(List.of(auction1, auction2, auction3, auction4));

        // Criar lances (biddings)

      // Bidding bid1 = new Bidding(new BigDecimal("10000.00"), LocalDateTime.now(), user1, auction1);
       // Bidding bid2 = new Bidding(new BigDecimal("12000.00"), LocalDateTime.now(), user2, auction1);
       // Bidding bid3 = new Bidding(new BigDecimal("500.00"), LocalDateTime.now(), user3, auction2);
       // biddingRepository.saveAll(List.of(bid1, bid2, bid3));

        System.out.println("Dados de exemplo carregados no banco H2!");
    }
}

