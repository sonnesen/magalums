package tech.buildrun.notifications.controller.dto;

import tech.buildrun.notifications.entity.Notification;

public record NotificationDTO(Long notificationId, String dateTime, String destination, String message, String channel,
        String status) {

    public static NotificationDTO fromNotification(Notification notification) {
        return new NotificationDTO(notification.getNotificationId(), notification.getDateTime().toString(),
                notification.getDestination(), notification.getMessage(), notification.getChannel().getDescription(),
                notification.getStatus().getDescription());
    }

}
