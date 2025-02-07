package com.example.leilao_produtos_spring_boot.models.repository;

import com.example.leilao_produtos_spring_boot.models.Auction;
import com.example.leilao_produtos_spring_boot.models.AuctionStatus;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositório JPA para gerir operações de banco de dados relacionadas à entidade Auction (Leilão).
 * Esta interface permite realizar operações CRUD (Create, Read, Update, Delete) automaticamente.
 */
@Repository // Indica que esta interface é um componente Spring responsável pelo acesso ao banco de dados
public interface AuctionRepository extends JpaRepository<Auction, Integer> {

    /**
     * Busca todos os leilões com um determinado status (ACTIVE ou CLOSED).
     *
     * @param status O status do leilão a ser buscado (ACTIVE ou CLOSED).
     * @return Lista de leilões que correspondem ao status especificado.
     */
    List<Auction> findByStatus(AuctionStatus status);
}
