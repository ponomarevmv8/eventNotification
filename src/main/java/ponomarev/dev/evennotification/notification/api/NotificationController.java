package ponomarev.dev.evennotification.notification.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ponomarev.dev.evennotification.notification.domain.NotificationService;
import ponomarev.dev.evennotification.notification.domain.NotificationUserService;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationDtoMapper notificationDtoMapper;
    private final NotificationUserService notificationUserService;

    public NotificationController(NotificationService notificationService, NotificationDtoMapper notificationDtoMapper, NotificationUserService notificationUserService) {
        this.notificationService = notificationService;
        this.notificationDtoMapper = notificationDtoMapper;
        this.notificationUserService = notificationUserService;
    }


    @GetMapping()
    public ResponseEntity<List<NotificationDto>> getNotifications() {
        return ResponseEntity.ok(
            notificationService.findAllNotificationsUsers()
                    .stream()
                    .map(notificationDtoMapper::toDto)
                    .toList()
        );
    }

    @PostMapping()
    public ResponseEntity<Void> readNotificationsUsers(
            @RequestBody List<Long> notificationIds
    ) {
        notificationUserService.readNotificationUsers(notificationIds);
        return ResponseEntity.noContent()
                .build();
    }

}
