package ponomarev.dev.evennotification.notification.domain;

import org.springframework.stereotype.Component;
import ponomarev.dev.evennotification.kafka.event.EventStatus;
import ponomarev.dev.evennotification.kafka.event.FieldChange;
import ponomarev.dev.evennotification.notification.db.NotificationEntity;
import ponomarev.dev.evennotification.notification.db.NotificationUserEntity;

@Component
public class NotificationMapper {

    public Notification toDomain(NotificationEntity notification) {
        return new Notification(
                notification.getId(),
                notification.getEventId(),
                notification.getUserIdChangeBy(),
                notification.getOwnerId(),
                new FieldChange<>(
                        notification.getOldName(),
                        notification.getNewName()
                ),
                new FieldChange<>(
                        notification.getOldMaxPlace(),
                        notification.getNewMaxPlace()
                ),
                new FieldChange<>(
                        notification.getOldDate(),
                        notification.getNewDate()
                ),
                new FieldChange<>(
                        notification.getOldCost(),
                        notification.getNewCost()
                ),
                new FieldChange<>(
                        notification.getOldLocationId(),
                        notification.getNewLocationId()
                ),
                new FieldChange<>(
                        notification.getOldStatus() != null ? EventStatus.valueOf(notification.getOldStatus()) : null,
                        notification.getNewStatus() != null ? EventStatus.valueOf(notification.getNewStatus()) : null
                ),
                notification.getCreated(),
                notification.getNotificationUsers()
                        .stream()
                        .map(notificationUserEntity ->
                                new NotificationUser(
                                        notificationUserEntity.getId(),
                                        notificationUserEntity.getNotification().getId(),
                                        notificationUserEntity.getUserId()
                                ))
                        .toList()
        );
    }

    public NotificationUser toDomain(NotificationUserEntity notificationUserEntity) {
        return new NotificationUser(
                notificationUserEntity.getId(),
                notificationUserEntity.getNotification().getId(),
                notificationUserEntity.getUserId()
        );
    }

}
