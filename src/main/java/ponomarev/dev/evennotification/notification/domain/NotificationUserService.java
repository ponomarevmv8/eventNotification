package ponomarev.dev.evennotification.notification.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ponomarev.dev.evennotification.notification.db.NotificationUserRepository;
import ponomarev.dev.evennotification.security.jwt.JwtAuthenticationService;

import java.util.List;

@Service
public class NotificationUserService {

    private static final Logger log = LoggerFactory.getLogger(NotificationUserService.class);
    private final NotificationUserRepository notificationUserRepository;
    private final JwtAuthenticationService jwtAuthenticationService;

    public NotificationUserService(NotificationUserRepository notificationUserRepository, JwtAuthenticationService jwtAuthenticationService) {
        this.notificationUserRepository = notificationUserRepository;
        this.jwtAuthenticationService = jwtAuthenticationService;
    }


    @Transactional
    public void readNotificationUsers(List<Long> notificationUserIds) {
        var user = jwtAuthenticationService.getCurrentAuthenticatedUserOrThrow();
        notificationUserRepository.readAllNotificationUsers(user.id(), notificationUserIds);
        log.info("Read notification users: {}: {}", user.username() ,notificationUserIds);
    }
}
