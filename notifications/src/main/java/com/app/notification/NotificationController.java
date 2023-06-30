package com.app.notification;


import com.app.clients.notifications.NotificationRequest;
import com.app.clients.notifications.NotificationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {

   // private final NotificationService notificationService;

//    @PostMapping("fraud-notification")
//    public NotificationResponse sendNotification(@RequestBody NotificationRequest request){
//        log.info("Sending Notification {} ", request);
//        Boolean status = notificationService.sendNotification(request.customerId(), request.email(), request.message());
//        return new NotificationResponse(request.customerId(), status);
//    }

}
