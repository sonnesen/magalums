package tech.buildrun.notifications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.buildrun.notifications.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
