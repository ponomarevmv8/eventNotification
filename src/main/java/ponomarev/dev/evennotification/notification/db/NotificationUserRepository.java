package ponomarev.dev.evennotification.notification.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NotificationUserRepository extends JpaRepository<NotificationUserEntity, Long> {

    @Modifying
    @Transactional
    @Query("""
            update NotificationUserEntity n
            set n.isRead = true
            where n.notification.id in :notificationsIds
            and n.userId = :userId
            """)
    void readAllNotificationUsers(
            @Param("userId") Long userId,
            @Param("notificationsIds") List<Long> notificationsIds
    );

    @Query("""
            select n from NotificationUserEntity n
            where n.notification.id in :notificationsIds
            """)
    List<NotificationUserEntity> findAllByEventId(
            @Param("notificationsIds") List<Long> notificationsIds
    );
}
