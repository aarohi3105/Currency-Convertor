package com.example.currencyconvertor.DTO;

public class ExchangeRateResponse {

    private String date;
    private String base;
    private String quote;
    private double rate;

    public String getDate() {
        return date;
    }

    public String getBase() {
        return base;
    }

    public String getQuote() {
        return quote;
    }

    public double getRate() {
        return rate;
    }
}