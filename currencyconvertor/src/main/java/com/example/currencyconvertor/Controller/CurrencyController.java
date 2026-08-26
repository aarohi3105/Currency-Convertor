package com.example.currencyconvertor.Controller;

import com.example.currencyconvertor.DTO.ConversionResponse;
import com.example.currencyconvertor.Service.CurrencyService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {

        this.currencyService = currencyService;
    }
    @GetMapping("/convert")
    public ConversionResponse convert(@NotBlank(message = "from currency is required")@RequestParam String from,
                                      @NotBlank(message = "To currency is required") @RequestParam String to,
                                      @Positive(message="amount must be greater than zero") @RequestParam double amount) {
        return currencyService.convertCurrency(from, to, amount);
    }
}
