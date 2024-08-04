package tech.buildrun.notifications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.buildrun.notifications.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
