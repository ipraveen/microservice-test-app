package com.app.clients.notifications;

public record NotificationRequest(Integer customerId, String name, String email, String message) {
}
