package com.example.currencyconvertor.Client;

import com.example.currencyconvertor.DTO.ExchangeRateResponse;
import com.example.currencyconvertor.Exception.ExternalApiException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.Map;

@Component
public class CurrencyClient {

    private final RestClient restClient;

    public CurrencyClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://api.frankfurter.dev")
                .build();
    }
    public ExchangeRateResponse getExchangeRate(String from, String to) {

        try {
            return restClient.get()
                    .uri("/v2/rate/{from}/{to}", from, to)
                    .retrieve()
                    .body(ExchangeRateResponse.class);

        } catch (RestClientException ex) {

            throw new ExternalApiException(
                    "Unable to fetch exchange rate"
            );
        }
    }

    public Map<String, String> getCurrencies() {



            try {
                return restClient.get()
                        .uri("/v1/currencies")
                        .retrieve()
                        .body(new ParameterizedTypeReference<Map<String, String>>() {});

            } catch (RestClientException ex) {

                throw new ExternalApiException(
                        "Unable to fetch supported currencies"
                );
            }
        }
}













































































































































