package adria.intership.subscribers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubscribersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubscribersApplication.class, args);
    }

}
