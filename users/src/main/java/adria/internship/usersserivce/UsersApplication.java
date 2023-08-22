package adria.internship.usersserivce;

import adria.internship.usersserivce.dto.*;
import adria.internship.usersserivce.services.AgenceServiceImpl;
import adria.internship.usersserivce.services.PaysVilleServiceImpl;
import adria.internship.usersserivce.services.ProfileServiceImpl;
import adria.internship.usersserivce.services.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
