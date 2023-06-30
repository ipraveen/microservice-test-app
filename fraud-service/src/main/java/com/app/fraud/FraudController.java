package com.app.fraud;


import com.app.clients.fraud.FraudCheckResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v1/frud-service")
@RestController
@RequiredArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;
    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudulent(@PathVariable("customerId") Integer customerId ){

        Boolean isFraudulent = fraudCheckService.isFraudulent(customerId);
        log.info("Fraud check request for customer: " + customerId);
        return new FraudCheckResponse(customerId, isFraudulent);
    }
}
