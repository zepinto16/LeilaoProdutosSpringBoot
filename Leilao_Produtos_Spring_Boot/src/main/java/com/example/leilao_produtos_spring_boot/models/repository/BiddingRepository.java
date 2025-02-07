package com.example.leilao_produtos_spring_boot.models.repository;

import com.example.leilao_produtos_spring_boot.models.AuctionStatus;
import com.example.leilao_produtos_spring_boot.models.Bidding;
import com.example.leilao_produtos_spring_boot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repositório JPA para gerir operações de banco de dados relacionadas à entidade Bidding (Licitações).
 * Esta interface fornece métodos para buscar licitações com base em diferentes critérios.
 */
@Repository // Indica que esta interface é um componente Spring responsável pelo acesso ao banco de dados
public interface BiddingRepository extends JpaRepository<Bidding, Integer> {

    /**
     * Busca todas as licitações feitas por um utilizador específico.
     *
     * @param userId ID do utilizador cujas licitações serão procuradas.
     * @return Lista das licitações feitas pelo utilizador.
     */
    List<Bidding> findByUserId(int userId);
    /**
     * Busca todas as licitações associadas a um determinado leilão.
     *
     * @param auctionId ID do leilão cujas licitações serão procuradas.
     * @return Lista de licitações dentro do leilão especificado.
     */
    List<Bidding> findByAuctionId(int auctionId);

    /**
     * Obtém a maior licitação atual para um determinado leilão.
     *
     * @param auctionId ID do leilão.
     * @return O maior valor da licitação para o leilão especificado.
     */
    @Query("SELECT MAX(b.price) FROM Bidding b WHERE b.auction.id = :auctionId")
    BigDecimal findHighestBidByAuctionId(int auctionId);

    /**
     * Busca todas as licitações de leilões que estão em um status específico (exemplo: ativos).
     *
     * @param status Status do leilão (ACTIVE ou CLOSED).
     * @return Lista de licitações de leilões que correspondem ao status especificado.
     */
    @Query("SELECT b FROM Bidding b WHERE b.auction.status = :status")
    List<Bidding> findBiddingsByAuctionStatus(AuctionStatus status);
}
