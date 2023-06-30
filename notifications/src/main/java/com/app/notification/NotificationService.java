package com.app.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Boolean sendNotification( Integer customerId, String email, String message){

        Notification notification = Notification.builder()
                .customerId(customerId)
                .sendTo(email)
                .sendFrom("notifications@microserviceapp.com")
                .sentAt(LocalDateTime.now())
                .message(message)
                .build();

        notificationRepository.save(notification);
        return true;
    }
}
