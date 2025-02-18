package ponomarev.dev.evennotification.notification.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

    @Query("""
            select n from NotificationEntity n
            join fetch n.notificationUsers nu
            where nu.userId = :userId
            and nu.isRead = false
            """)
    List<NotificationEntity> findAllByUserId(
            @Param("userId") Long userId);

    @Query("""
            select n from NotificationEntity n
            where n.created < :day
            """)
    List<NotificationEntity> findAllNotificationsOlderThanDay(
            @Param("day") LocalDateTime day
            );

}
