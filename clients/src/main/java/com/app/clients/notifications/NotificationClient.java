package com.app.clients.notifications;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("NOTIFICATIONS")
public interface NotificationClient {

    @PostMapping ("api/v1/notification/fraud-notification")
    NotificationResponse sendNotification(@RequestBody NotificationRequest request);
}
