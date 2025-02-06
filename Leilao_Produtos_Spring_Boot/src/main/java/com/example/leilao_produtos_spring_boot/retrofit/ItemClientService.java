package com.example.leilao_produtos_spring_boot.retrofit;

import com.example.leilao_produtos_spring_boot.models.dto.PendentItemResponseDTO;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;


@Service
public class ItemClientService {

    String API_BASE_URL = "http://localhost:5007/api/item/";

    private ItemClientAPI itemClientAPI;

    public ItemClientService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        this.itemClientAPI = retrofit.create(ItemClientAPI.class);
    }


    public List<PendentItemResponseDTO> GetPendingItems() {
        try {
            Response<List<PendentItemResponseDTO>> response = itemClientAPI.GetPendingItems().execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            } else {
                throw new RuntimeException("Erro ao carregar items pendentes: " + (response.errorBody() != null ? response.errorBody().string() : "Resposta vazia"));
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro na requisição para a API C#", e);
        }
    }
}
