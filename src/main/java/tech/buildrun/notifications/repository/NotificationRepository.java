package tech.buildrun.notifications.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.buildrun.notifications.entity.Notification;
import tech.buildrun.notifications.entity.Status;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByStatusInAndDateTimeBefore(List<Status> statuses, LocalDateTime dateTime);
}
