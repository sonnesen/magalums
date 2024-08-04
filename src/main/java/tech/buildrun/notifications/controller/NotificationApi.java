package tech.buildrun.notifications.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.buildrun.notifications.controller.dto.ScheduleNotificationDTO;

@RequestMapping("/notifications")
public interface NotificationApi {

    @PostMapping
    ResponseEntity<?> scheduleNotification(@RequestBody ScheduleNotificationDTO scheduleNotificationDTO);

    @GetMapping("/{notificationId}")
    ResponseEntity<?> getNotification(@PathVariable Long notificationId);

    @DeleteMapping("/{notificationId}")
    ResponseEntity<Void> cancelNotification(@PathVariable Long notificationId);
}
