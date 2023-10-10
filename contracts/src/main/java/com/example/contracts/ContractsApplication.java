package com.example.contracts;

import com.example.contracts.dto.ContratDto;
import com.example.contracts.enums.TypeContrat;
import com.example.contracts.services.ContratImpl;
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
public class ContractsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractsApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ContratImpl contratService){
        return args ->{
            ContratDto contratDto=new ContratDto();
            contratDto.setBoDto(null);
            contratDto.setTypeContrat(TypeContrat.particulier);
            contratDto.setDateActivation(new Date());
            contratDto.setNbMaxTransfert(60);
            contratDto.setNbMinTransfert(30);
            contratDto.setDateActivation(new Date());
            log.info("contrat : "+contratService.saveContratParticulier(contratDto));

        };
    }
}
