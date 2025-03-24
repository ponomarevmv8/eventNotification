package ponomarev.dev.evennotification.notification.api;

import org.springframework.stereotype.Component;
import ponomarev.dev.evennotification.notification.domain.Notification;

@Component
public class NotificationDtoMapper {

    public NotificationDto toDto(Notification notification) {
        return new NotificationDto(
                notification.getEventId(),
                notification.getName(),
                notification.getMaxPlace(),
                notification.getDate(),
                notification.getCost(),
                notification.getLocationId(),
                notification.getStatus()
        );
    }

}
