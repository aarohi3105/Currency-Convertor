# Currency Converter API

A RESTful Currency Converter application built using **Java and Spring Boot**. The application accepts a source currency, target currency, and amount, fetches the latest exchange rate from the **Frankfurter API**, and returns the converted amount.

## Features

* Convert amounts between supported currencies
* Fetch supported currencies from the external API
* Input validation using Jakarta Bean Validation
* Custom exception handling
* Centralized error handling using `@RestControllerAdvice`
* External API error handling
* Currency code normalization (`usd` → `USD`)
* Same-currency conversion without an external API call
* Rounded conversion results to two decimal places

## Tech Stack

* Java
* Spring Boot
* Spring Web
* REST APIs
* RestClient
* Jackson
* Jakarta Bean Validation
* Maven
* Frankfurter API

## Project Architecture

```text
Client / Browser
       ↓
Controller
       ↓
Service
       ↓
CurrencyClient
       ↓
Frankfurter API
```

### Layers

**Controller**

Handles HTTP requests, request parameters, and input validation.

**Service**

Contains the business logic, validates currencies, calculates the converted amount, and creates the response DTO.

**Client**

Communicates with the external Frankfurter API using Spring `RestClient`.

**DTO**

Transfers structured data between different layers of the application.

**Exception**

Contains custom exceptions and centralized exception handling.

## API Endpoints

### 1. Convert Currency

```http
GET /convert
```

Example:

```text
http://localhost:8080/convert?from=USD&to=INR&amount=100
```

Example response:

```json
{
  "from": "USD",
  "to": "INR",
  "amount": 100.0,
  "exchangeRate": 87.5,
  "convertedAmount": 8750.0
}
```

> The exchange rate shown above is only an example. The actual rate is fetched from the external API and may change.

### 2. Get Supported Currencies

```http
GET /currencies
```

Example:

```text
http://localhost:8080/currencies
```

Returns the currencies supported by the external API.

## Validation and Error Handling

The application handles different types of errors.

### Invalid amount

```text
/convert?from=USD&to=INR&amount=-100
```

Response:

```json
{
  "errors": [
    "amount must be greater than zero"
  ]
}
```

### Invalid currency

```text
/convert?from=ABC&to=INR&amount=100
```

Response:

```json
{
  "errors": [
    "Invalid from currency: ABC"
  ]
}
```

### Missing parameter

```text
/convert?from=USD&to=INR
```

The application returns a `400 Bad Request` response indicating that the required parameter is missing.

### External API failure

If the external currency API is unavailable, the application handles the failure through a custom `ExternalApiException` and returns an appropriate error response.

## Request Flow

```text
1. Client sends conversion request
          ↓
2. Controller receives request parameters
          ↓
3. Bean Validation validates the input
          ↓
4. Service normalizes and validates currencies
          ↓
5. CurrencyClient calls Frankfurter API
          ↓
6. API returns JSON response
          ↓
7. Jackson maps JSON to ExchangeRateResponse DTO
          ↓
8. Service extracts exchange rate
          ↓
9. Converted amount is calculated
          ↓
10. ConversionResponse object is created
          ↓
11. Jackson converts the object to JSON
          ↓
12. JSON response is returned to the client
```

## Running the Project

### Prerequisites

* Java JDK
* Maven
* Internet connection

### Run

Clone the repository and open it in IntelliJ IDEA or another Java IDE.

Run the Spring Boot application.

The application will start on:

```text
http://localhost:8080
```

## External API

This project uses the **Frankfurter API** to retrieve currency exchange rates and supported currencies.

## Future Improvements

* React-based frontend
* Currency dropdowns
* Conversion history
* Better caching with Spring Cache
* Unit and integration tests
* Deployment to a cloud platform
