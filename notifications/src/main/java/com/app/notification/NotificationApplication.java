package com.app.notification;

import com.app.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        scanBasePackages = {"com.app.notification", "com.app.amqp"}
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.app.clients"
)
public class NotificationApplication {

    public static void main(String[] args) {

        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig){
//        return args -> {
//              producer.publish(notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKey(), "foo");
//        };
//    }
}
