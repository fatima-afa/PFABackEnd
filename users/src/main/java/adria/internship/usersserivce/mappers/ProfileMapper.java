package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.ProfileDto;
import adria.internship.usersserivce.dto.VilleDto;
import adria.internship.usersserivce.entities.Profile;
import adria.internship.usersserivce.entities.Ville;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileMapper {
    public ProfileDto profileToDto(Profile profile){

        ProfileDto profileDto = new ProfileDto();
        BeanUtils.copyProperties(profile, profileDto);

        return profileDto;
    }

    public Profile profileDtoToProfile(ProfileDto profileDto){

        Profile profile = new Profile();
        BeanUtils.copyProperties(profileDto, profile);

        return profile;
    }
}
