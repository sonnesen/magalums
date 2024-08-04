package tech.buildrun.notifications.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import tech.buildrun.notifications.controller.dto.NotificationDTO;
import tech.buildrun.notifications.controller.dto.ScheduleNotificationDTO;
import tech.buildrun.notifications.service.NotificationService;

@RestController
@RequiredArgsConstructor
public class NotificationController implements NotificationApi {

    @NonNull
    private final NotificationService notificationService;

    @Override
    public ResponseEntity<Void> scheduleNotification(ScheduleNotificationDTO scheduleNotificationDTO) {
        notificationService.scheduleNotification(scheduleNotificationDTO);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<NotificationDTO> getNotification(Long notificationId) {
        return notificationService.getNotification(notificationId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> cancelNotification(Long notificationId) {
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.noContent().build();
    }

}
