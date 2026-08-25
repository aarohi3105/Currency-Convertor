package com.example.currencyconvertor.DTO;

public class ConversionResponse {

    private String from;
    private String to;
    private double amount;
    private double exchangeRate;
    private double convertedAmount;

    public ConversionResponse(String from, String to, double amount,
                              double exchangeRate, double convertedAmount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.exchangeRate = exchangeRate;
        this.convertedAmount = convertedAmount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }
}