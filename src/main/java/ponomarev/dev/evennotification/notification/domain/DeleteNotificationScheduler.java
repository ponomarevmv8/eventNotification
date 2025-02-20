package ponomarev.dev.evennotification.notification.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ponomarev.dev.evennotification.notification.db.NotificationEntity;
import ponomarev.dev.evennotification.notification.db.NotificationRepository;
import ponomarev.dev.evennotification.notification.db.NotificationUserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableScheduling
public class DeleteNotificationScheduler {

    private static final Logger log = LoggerFactory.getLogger(DeleteNotificationScheduler.class);
    private final NotificationRepository notificationRepository;

    public DeleteNotificationScheduler(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    @Scheduled(fixedRateString = "#{${scheduled.update.fixedrate}}")
    public void notificationDeleted() {
        log.info("Deleting notifications with a creation date older than 7 days");
        List<NotificationEntity> notificationToDelete = notificationRepository.findAllNotificationsOlderThanDay(
                LocalDateTime.now().minusDays(7)
        );
        if(notificationToDelete.isEmpty()) {
            return;
        }

        notificationRepository.deleteAll(notificationToDelete);
    }



}
