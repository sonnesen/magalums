package tech.buildrun.notifications.scheduler;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tech.buildrun.notifications.service.NotificationService;

@RequiredArgsConstructor
@Component
@Slf4j
public class NotificationScheduler {

    @NonNull
    private final NotificationService notificationService;

    @Scheduled(cron = "${notification.cron.expression}")
    public void sendNotifications() {
        final var now = LocalDateTime.now();
        log.info("Starting to send notifications at {}", now);
        notificationService.sendNotifications(now);
    }
}
