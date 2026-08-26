package com.example.currencyconvertor.DTO;
import java.util.List;
public class ErrorResponse {

//    private String error;
//
//    public ErrorResponse(String error) {
//        this.error = error;
//    }
//
//    public String getError() {
//        return error;
//    }

        private List<String> errors;         // <2>

        public ErrorResponse(List<String> errors) {              // Yahan list object ke andar store ho gayi:
            this.errors = errors;
        }   //all the collected error messages are stored here

        public List<String> getErrors() {
            return errors;
        }
    }
//Error case mein GlobalExceptionHandler ErrorResponse DTO return karta hai, aur Spring/Jackson us DTO ko JSON format mein browser ko output karta hai.