package com.example.currencyconvertor.Client;

import com.example.currencyconvertor.DTO.ExchangeRateResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CurrencyClient {

    private final RestClient restClient;

    public CurrencyClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://api.frankfurter.dev")
                .build();
    }
    public ExchangeRateResponse getExchangeRate(String from, String to) {               //response is obtained from here

        return restClient.get()
                .uri("/v2/rate/{from}/{to}", from, to)
                .retrieve()
                .body(ExchangeRateResponse.class);
    }
}













































































































































