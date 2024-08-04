package tech.buildrun.notifications.service;

import java.time.LocalDateTime;
import java.util.Optional;

import tech.buildrun.notifications.controller.dto.NotificationDTO;
import tech.buildrun.notifications.controller.dto.ScheduleNotificationDTO;

public interface NotificationService {

    void scheduleNotification(ScheduleNotificationDTO scheduleNotificationDTO);

    Optional<NotificationDTO> getNotification(Long notificationId);

    void cancelNotification(Long notificationId);

    void sendNotifications(final LocalDateTime dateTime);
}