package tech.buildrun.notifications.controller.dto;

import java.time.LocalDateTime;

import tech.buildrun.notifications.entity.Channel;
import tech.buildrun.notifications.entity.Notification;
import tech.buildrun.notifications.entity.Status;

public record ScheduleNotificationDTO(LocalDateTime dateTime, String destination, String message,
        String channel) {

    public Notification toNotification() {
        return Notification.builder()
                .dateTime(dateTime)
                .destination(destination)
                .message(message)
                .channel(Channel.Values.valueOf(channel.toUpperCase()).toChannel())
                .status(Status.Values.PENDING.toStatus())
                .build();
    }
}
