package ponomarev.dev.evennotification.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ponomarev.dev.evennotification.kafka.event.EventChangeKafkaEvent;
import ponomarev.dev.evennotification.notification.domain.NotificationService;

@Component
public class EventKafkaListener {

    private static final Logger log = LoggerFactory.getLogger(EventKafkaListener.class);
    private final NotificationService notificationService;

    public EventKafkaListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "event-change", containerFactory = "containerFactory")
    public void listenEvent(
            ConsumerRecord<Long, EventChangeKafkaEvent> record
    ) {
        log.info("Received event {}", record.value());
        notificationService.createNotificationFromKafka(record.value());
    }

}
