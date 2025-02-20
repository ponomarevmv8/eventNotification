package ponomarev.dev.evennotification.notification.api;

import java.util.List;

public record NotificationIdsDto(
        List<Long> notificationIds
) {
}
