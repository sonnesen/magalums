package tech.buildrun.notifications.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tech.buildrun.notifications.controller.dto.NotificationDTO;
import tech.buildrun.notifications.controller.dto.ScheduleNotificationDTO;
import tech.buildrun.notifications.entity.Status;
import tech.buildrun.notifications.repository.NotificationRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @NonNull
    private final NotificationRepository notificationRepository;

    @Override
    public void scheduleNotification(final ScheduleNotificationDTO scheduleNotificationDTO) {
        notificationRepository.save(scheduleNotificationDTO.toNotification());
    }

    @Override
    public Optional<NotificationDTO> getNotification(final Long notificationId) {
        return notificationRepository.findById(notificationId).map(NotificationDTO::fromNotification);
    }

    @Override
    public void cancelNotification(final Long notificationId) {
        final var notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found"));

        notification.setStatus(Status.Values.CANCELED.toStatus());
        notificationRepository.save(notification);
    }

    @Override
    public void sendNotifications(final LocalDateTime dateTime) {
        final var notifications = notificationRepository
                .findByStatusInAndDateTimeBefore(
                        List.of(Status.Values.PENDING.toStatus(), Status.Values.ERROR.toStatus()),
                        dateTime);

        notifications.forEach(notification -> {
            log.info("Notification {} sent", notification.getNotificationId());
            notification.setStatus(Status.Values.SENT.toStatus());
            notificationRepository.save(notification);
        });
    }

}
