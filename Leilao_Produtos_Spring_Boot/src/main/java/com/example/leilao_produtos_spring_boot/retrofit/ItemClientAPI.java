package com.example.leilao_produtos_spring_boot.retrofit;

import com.example.leilao_produtos_spring_boot.models.dto.PendentItemResponseDTO;
import com.example.leilao_produtos_spring_boot.models.dto.SaleRequestDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface ItemClientAPI {
    @GET("pending")
    public Call<List<PendentItemResponseDTO>> GetPendingItems();

    @POST("/api/sale")
    Call<Void> registerSale(@Body SaleRequestDTO saleRequestDTO);
}


