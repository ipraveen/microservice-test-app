package com.app.clients.fraud;

public record FraudCheckResponse(Integer customerId, Boolean isFraudster) {
}
