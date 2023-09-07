package adria.intership.subscribers;

import adria.intership.subscribers.dto.AbonneDto;
import adria.intership.subscribers.services.AbonneServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class SubscribersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubscribersApplication.class, args);
    }

//    @Bean
//    CommandLineRunner start(AbonneServiceImpl abonneService){
//        return args ->{
//            AbonneDto abonneDto=new AbonneDto();
//            abonneDto.setNom("najwa");
//            abonneDto.setPrenom("NAJWA");
//            abonneDto.setAdresse("fbss");
//            abonneDto.setCIN("Ib233");
//            abonneDto.setEmail("leghrisnajwa@gmail.com");
//            log.info("contrat : "+abonneService.saveAbonne(abonneDto));
//
//        };
//    }
}
