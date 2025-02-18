package ponomarev.dev.evennotification.notification.domain;

public class NotificationUser {

    private Long id;
    private Long notification;
    private Long userId;

    public NotificationUser() {
    }

    public NotificationUser(Long id, Long notification, Long userId) {
        this.id = id;
        this.notification = notification;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNotification() {
        return notification;
    }

    public void setNotification(Long notification) {
        this.notification = notification;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
