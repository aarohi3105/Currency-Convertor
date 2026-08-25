package com.example.currencyconvertor.Service;

import com.example.currencyconvertor.Client.CurrencyClient;
import com.example.currencyconvertor.DTO.ConversionResponse;
import com.example.currencyconvertor.DTO.ExchangeRateResponse;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    private final CurrencyClient currencyClient;

    public CurrencyService(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    public ConversionResponse convertCurrency(String from, String to, double amount) {

        ExchangeRateResponse response =
                currencyClient.getExchangeRate(from, to);

        double exchangeRate = response.getRate();

        double convertedAmount = amount * exchangeRate;

        return new ConversionResponse(
                from,
                to,
                amount,
                exchangeRate,
                convertedAmount
        );
    }
}
