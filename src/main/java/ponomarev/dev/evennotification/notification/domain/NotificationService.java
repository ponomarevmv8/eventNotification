package ponomarev.dev.evennotification.notification.domain;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ponomarev.dev.evennotification.kafka.event.EventChangeKafkaEvent;
import ponomarev.dev.evennotification.kafka.event.FieldChange;
import ponomarev.dev.evennotification.notification.db.NotificationEntity;
import ponomarev.dev.evennotification.notification.db.NotificationRepository;
import ponomarev.dev.evennotification.notification.db.NotificationUserEntity;
import ponomarev.dev.evennotification.notification.db.NotificationUserRepository;
import ponomarev.dev.evennotification.security.jwt.JwtAuthenticationService;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final NotificationUserRepository notificationUserRepository;
    private final JwtAuthenticationService jwtAuthenticationService;

    public NotificationService(NotificationRepository notificationRepository, NotificationMapper notificationMapper, NotificationUserRepository notificationUserRepository, JwtAuthenticationService jwtAuthenticationService) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
        this.notificationUserRepository = notificationUserRepository;
        this.jwtAuthenticationService = jwtAuthenticationService;
    }

    @Transactional
    public Notification createNotificationFromKafka(EventChangeKafkaEvent event) {
        NotificationEntity notificationEvent = new NotificationEntity(
                null,
                event.getEventId(),
                event.getUserChangeBy(),
                event.getOwnerId(),
                FieldChange.getOldField(event.getName()),
                FieldChange.getNewField(event.getName()),
                FieldChange.getOldField(event.getMaxPlace()),
                FieldChange.getNewField(event.getMaxPlace()),
                FieldChange.getOldField(event.getDate()),
                FieldChange.getNewField(event.getDate()),
                FieldChange.getOldField(event.getCost()),
                FieldChange.getNewField(event.getCost()),
                FieldChange.getOldField(event.getDuration()),
                FieldChange.getNewField(event.getDuration()),
                FieldChange.getOldField(event.getLocationId()),
                FieldChange.getNewField(event.getLocationId()),
                event.getStatus() != null ? event.getStatus().getOldField().name() : null,
                event.getStatus() != null ? event.getStatus().getNewField().name() : null,
                LocalDateTime.now(),
                List.of()
        );

        var notificationSave = notificationRepository.save(notificationEvent);

        notificationUserRepository.saveAll(
                event.getParticipantList()
                        .stream()
                        .map(userId -> new NotificationUserEntity(
                                null,
                                notificationSave,
                                userId,
                                false
                        ))
                        .toList()
        );

        log.info("Created notification: {}", notificationSave);

        return notificationMapper.toDomain(notificationSave);
    }

    public List<Notification> findAllNotificationsUsers() {
        var user = jwtAuthenticationService.getCurrentAuthenticatedUserOrThrow();
        var notificationsUser = notificationRepository.findAllByUserId(user.id())
                .stream()
                .map(notificationMapper::toDomain)
                .toList();
        if (notificationsUser.isEmpty()) {
            throw new EntityNotFoundException("The user has no unread notifications.");
        }
        log.info("Found {} notifications", notificationsUser.size());
        return notificationsUser;
    }
}
