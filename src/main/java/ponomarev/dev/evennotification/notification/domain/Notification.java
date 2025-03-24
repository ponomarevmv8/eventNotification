package ponomarev.dev.evennotification.notification.domain;

import ponomarev.dev.evennotification.kafka.event.EventStatus;
import ponomarev.dev.evennotification.kafka.event.FieldChange;

import java.time.LocalDateTime;
import java.util.List;

public class Notification {
    private Long id;

    private Long eventId;

    private Long userIdChangeBy;

    private Long ownerId;

    private FieldChange<String> name;

    private FieldChange<Integer> maxPlace;

    private FieldChange<LocalDateTime> date;

    private FieldChange<Integer> cost;

    private FieldChange<Long> locationId;

    private FieldChange<EventStatus> status;

    private LocalDateTime created;

    private List<NotificationUser> notificationUserList;

    public Notification() {
    }

    public Notification(Long id, Long eventId, Long userIdChangeBy, Long ownerId, FieldChange<String> name, FieldChange<Integer> maxPlace, FieldChange<LocalDateTime> date, FieldChange<Integer> cost, FieldChange<Long> locationId, FieldChange<EventStatus> status, LocalDateTime created, List<NotificationUser> notificationUserList) {
        this.id = id;
        this.eventId = eventId;
        this.userIdChangeBy = userIdChangeBy;
        this.ownerId = ownerId;
        this.name = name;
        this.maxPlace = maxPlace;
        this.date = date;
        this.cost = cost;
        this.locationId = locationId;
        this.status = status;
        this.created = created;
        this.notificationUserList = notificationUserList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserIdChangeBy() {
        return userIdChangeBy;
    }

    public void setUserIdChangeBy(Long userIdChangeBy) {
        this.userIdChangeBy = userIdChangeBy;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public FieldChange<String> getName() {
        return name;
    }

    public void setName(FieldChange<String> name) {
        this.name = name;
    }

    public FieldChange<Integer> getMaxPlace() {
        return maxPlace;
    }

    public void setMaxPlace(FieldChange<Integer> maxPlace) {
        this.maxPlace = maxPlace;
    }

    public FieldChange<LocalDateTime> getDate() {
        return date;
    }

    public void setDate(FieldChange<LocalDateTime> date) {
        this.date = date;
    }

    public FieldChange<Integer> getCost() {
        return cost;
    }

    public void setCost(FieldChange<Integer> cost) {
        this.cost = cost;
    }

    public FieldChange<Long> getLocationId() {
        return locationId;
    }

    public void setLocationId(FieldChange<Long> locationId) {
        this.locationId = locationId;
    }

    public FieldChange<EventStatus> getStatus() {
        return status;
    }

    public void setStatus(FieldChange<EventStatus> status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<NotificationUser> getNotificationUserList() {
        return notificationUserList;
    }

    public void setNotificationUserList(List<NotificationUser> notificationUserList) {
        this.notificationUserList = notificationUserList;
    }
}
