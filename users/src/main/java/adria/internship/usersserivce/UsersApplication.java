package adria.internship.usersserivce;

import adria.internship.usersserivce.dto.*;
import adria.internship.usersserivce.services.AgenceServiceImpl;
import adria.internship.usersserivce.services.PaysVilleServiceImpl;
import adria.internship.usersserivce.services.ProfileServiceImpl;
import adria.internship.usersserivce.services.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(UserServiceImpl userService,
										PaysVilleServiceImpl villeService,
										ProfileServiceImpl profileService,
										AgenceServiceImpl agenceService){
		return args -> {
			Stream.of("Mohammedia","beni malal").forEach(ville->{
				PaysDto paysDto=new PaysDto();
				paysDto.setNom(ville);
				PaysDto paysDto1=villeService.savePays(paysDto);
				VilleDto villeDto=new VilleDto();
				villeDto.setNom(ville);
				villeDto.setPaysDto(paysDto1);
				VilleDto villeDto1=villeService.saveVille(villeDto);
				ProfileDto profileDto=new ProfileDto();
				profileDto.setProfile(ville);
				ProfileDto profileDto1=profileService.saveprofile(profileDto);
				AgenceDto agenceDto=new AgenceDto();
				agenceDto.setVilleDto(villeDto1);
				agenceDto.setIntituleAgence(ville);
				AgenceDto agenceDto1=agenceService.saveAgence(agenceDto);
				//Stream.of("AFA","Nejwa").forEach(name->{
					AdminDto adminDto=new AdminDto();
					adminDto.setNom(ville);
					adminDto.setEmail(ville+"@gmail.com");
					adminDto.setAgenceDto(agenceDto1);
					//adminDto.setAgenceDto(null);
					adminDto.setProfileDto(profileDto1);
					//adminDto.setProfileDto(null);
					userService.saveAdmin(adminDto);
				//});
			});



		};
	}
}
