package com.app.customerservice;

import com.app.amqp.RabbitMQMessageProducer;
import com.app.clients.fraud.FraudCheckResponse;
import com.app.clients.fraud.FraudClient;
import com.app.clients.notifications.NotificationClient;
import com.app.clients.notifications.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final FraudClient fraudClient;

    private final RabbitMQMessageProducer producer;

    public void registerCustomer(CustomerRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        this.customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudulent(customer.getId());


        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getFirstName(),
                customer.getEmail(),
                String.format("Hi %s, Welcome to Microservice App", customer.getFirstName()));

        producer.publish("internal.exchange", "internal.notification.routing-key", notificationRequest);

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("This customer is a Fraudster");
        }
   }
}
