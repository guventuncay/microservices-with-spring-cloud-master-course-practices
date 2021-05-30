package com.in28.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name="default")
    // adı üstünde rate limiter
    @Bulkhead(name = "default")
    public String sampleApi() {

        logger.info("sample Api call received.");

//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/wrong-url", String.class);

        return "sample API";
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}
