package com.app.fraud;

import com.app.clients.notifications.NotificationClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private final FraudCheckRepository repository;



    public Boolean isFraudulent(Integer customerId){

        Fraud fraud = Fraud.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(fraud);



        return false;

    }
}
