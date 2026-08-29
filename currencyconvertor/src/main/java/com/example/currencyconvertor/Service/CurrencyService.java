package com.example.currencyconvertor.Service;

import com.example.currencyconvertor.Client.CurrencyClient;
import com.example.currencyconvertor.DTO.ConversionResponse;
import com.example.currencyconvertor.DTO.ExchangeRateResponse;
import org.springframework.stereotype.Service;

import com.example.currencyconvertor.Exception.InvalidCurrencyException;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Service
public class CurrencyService {

    private final CurrencyClient currencyClient;
    private Map<String, String> currencies;
  //  private final Set<String> supportedCurrencies = Set.of("USD", "INR", "EUR", "GBP", "JPY");

    public CurrencyService(CurrencyClient currencyClient) {

        this.currencyClient = currencyClient;
    }

    public ConversionResponse convertCurrency(String from, String to, double amount) {
//        Map<String, String> currencies = currencyClient.getCurrencies();
        from = from.trim().toUpperCase();
        to = to.trim().toUpperCase();
        Map<String, String> currencies =
                getSupportedCurrencies();

        if (!currencies.containsKey(from)) {
            throw new InvalidCurrencyException(
                    "Invalid from currency: " + from);
        }

        if (!currencies.containsKey(to)) {
            throw new InvalidCurrencyException(
                    "Invalid to currency: " + to);
        }
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

    public Map<String, String> getCurrencies() {
        return currencyClient.getCurrencies();
    }
    private Map<String, String> getSupportedCurrencies() {

        if (currencies == null) {
            currencies = currencyClient.getCurrencies();
        }

        return currencies;
    }
}
