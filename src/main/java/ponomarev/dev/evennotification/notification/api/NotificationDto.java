package ponomarev.dev.evennotification.notification.api;

import ponomarev.dev.evennotification.kafka.event.EventStatus;
import ponomarev.dev.evennotification.kafka.event.FieldChange;

import java.time.LocalDateTime;

public record NotificationDto(

        Long eventId,

        FieldChange<String> name,

        FieldChange<Integer> maxPlace,

        FieldChange<LocalDateTime> date,

        FieldChange<Integer> cost,

        FieldChange<Long> locationId,

        FieldChange<EventStatus> status
) {
}
