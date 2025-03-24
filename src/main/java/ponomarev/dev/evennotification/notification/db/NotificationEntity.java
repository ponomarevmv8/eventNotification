package ponomarev.dev.evennotification.notification.db;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "notification")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "change_by")
    private Long userIdChangeBy;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "old_name")
    private String oldName;
    @Column(name = "new_name")
    private String newName;

    @Column(name = "old_max_place")
    private Integer oldMaxPlace;
    @Column(name = "new_max_place")
    private Integer newMaxPlace;

    @Column(name = "old_date")
    private LocalDateTime oldDate;
    @Column(name = "new_date")
    private LocalDateTime newDate;

    @Column(name = "old_cost")
    private Integer oldCost;
    @Column(name = "new_cost")
    private Integer newCost;

    @Column(name = "old_duration")
    private Integer oldDuration;
    @Column(name = "new_duration")
    private Integer newDuration;

    @Column(name = "old_location_id")
    private Long oldLocationId;
    @Column(name = "new_location_id")
    private Long newLocationId;

    @Column(name = "old_status")
    private String oldStatus;
    @Column(name = "new_status")
    private String newStatus;

    @Column(name = "created")
    private LocalDateTime created;

    @OneToMany(mappedBy = "notification", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<NotificationUserEntity> notificationUsers;

    public NotificationEntity() {
    }

    public NotificationEntity(Long id, Long eventId, Long userIdChangeBy, Long ownerId, String oldName, String newName, Integer oldMaxPlace, Integer newMaxPlace, LocalDateTime oldDate, LocalDateTime newDate, Integer oldCost, Integer newCost, Integer oldDuration, Integer newDuration, Long oldLocationId, Long newLocationId, String oldStatus, String newStatus, LocalDateTime created) {
        this.id = id;
        this.eventId = eventId;
        this.userIdChangeBy = userIdChangeBy;
        this.ownerId = ownerId;
        this.oldName = oldName;
        this.newName = newName;
        this.oldMaxPlace = oldMaxPlace;
        this.newMaxPlace = newMaxPlace;
        this.oldDate = oldDate;
        this.newDate = newDate;
        this.oldCost = oldCost;
        this.newCost = newCost;
        this.oldDuration = oldDuration;
        this.newDuration = newDuration;
        this.oldLocationId = oldLocationId;
        this.newLocationId = newLocationId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.created = created;
    }

    public NotificationEntity(Long id, Long eventId, Long userIdChangeBy, Long ownerId, String oldName, String newName, Integer oldMaxPlace, Integer newMaxPlace, LocalDateTime oldDate, LocalDateTime newDate, Integer oldCost, Integer newCost, Integer oldDuration, Integer newDuration, Long oldLocationId, Long newLocationId, String oldStatus, String newStatus, LocalDateTime created, List<NotificationUserEntity> notificationUsers) {
        this.id = id;
        this.eventId = eventId;
        this.userIdChangeBy = userIdChangeBy;
        this.ownerId = ownerId;
        this.oldName = oldName;
        this.newName = newName;
        this.oldMaxPlace = oldMaxPlace;
        this.newMaxPlace = newMaxPlace;
        this.oldDate = oldDate;
        this.newDate = newDate;
        this.oldCost = oldCost;
        this.newCost = newCost;
        this.oldDuration = oldDuration;
        this.newDuration = newDuration;
        this.oldLocationId = oldLocationId;
        this.newLocationId = newLocationId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.created = created;
        this.notificationUsers = notificationUsers;
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

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Integer getOldMaxPlace() {
        return oldMaxPlace;
    }

    public void setOldMaxPlace(Integer oldMaxPlace) {
        this.oldMaxPlace = oldMaxPlace;
    }

    public Integer getNewMaxPlace() {
        return newMaxPlace;
    }

    public void setNewMaxPlace(Integer newMaxPlace) {
        this.newMaxPlace = newMaxPlace;
    }

    public LocalDateTime getOldDate() {
        return oldDate;
    }

    public void setOldDate(LocalDateTime oldDate) {
        this.oldDate = oldDate;
    }

    public LocalDateTime getNewDate() {
        return newDate;
    }

    public void setNewDate(LocalDateTime newDate) {
        this.newDate = newDate;
    }

    public Integer getOldCost() {
        return oldCost;
    }

    public void setOldCost(Integer oldCost) {
        this.oldCost = oldCost;
    }

    public Integer getNewCost() {
        return newCost;
    }

    public void setNewCost(Integer newCost) {
        this.newCost = newCost;
    }

    public Integer getOldDuration() {
        return oldDuration;
    }

    public void setOldDuration(Integer oldDuration) {
        this.oldDuration = oldDuration;
    }

    public Integer getNewDuration() {
        return newDuration;
    }

    public void setNewDuration(Integer newDuration) {
        this.newDuration = newDuration;
    }

    public Long getOldLocationId() {
        return oldLocationId;
    }

    public void setOldLocationId(Long oldLocationId) {
        this.oldLocationId = oldLocationId;
    }

    public Long getNewLocationId() {
        return newLocationId;
    }

    public void setNewLocationId(Long newLocationId) {
        this.newLocationId = newLocationId;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<NotificationUserEntity> getNotificationUsers() {
        return notificationUsers;
    }

    public void setNotificationUsers(List<NotificationUserEntity> notificationUsers) {
        this.notificationUsers = notificationUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
