package com.example.currencyconvertor.Controller;

import com.example.currencyconvertor.DTO.ConversionResponse;
import com.example.currencyconvertor.Service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {

        this.currencyService = currencyService;
    }
    @GetMapping("/convert")
    public ConversionResponse convert(@RequestParam String from,
                                      @RequestParam String to,
                                      @RequestParam double amount) {
        return currencyService.convertCurrency(from, to, amount);
    }
}
