package ponomarev.dev.evennotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class EvenNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvenNotificationApplication.class, args);
    }

}
