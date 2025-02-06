package com.example.leilao_produtos_spring_boot.webclient;

import com.example.leilao_produtos_spring_boot.models.dto.PendentItemResponseDTO;
import com.example.leilao_produtos_spring_boot.retrofit.ItemClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("api/v1/withRetrofit/item")
public class ConsumeItemClientWithRetrofit {

    private final ItemClientService itemClientService;

    public ConsumeItemClientWithRetrofit(ItemClientService itemClientService) {
        this.itemClientService = itemClientService;
    }

    @GetMapping("pending")
    public List<PendentItemResponseDTO> GetPendingItems() {
        return itemClientService.GetPendingItems();
    }
}