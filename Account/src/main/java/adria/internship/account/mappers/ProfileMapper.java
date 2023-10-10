package adria.internship.account.mappers;


import adria.internship.account.dto.ProfileDto;
import adria.internship.account.entities.Profile;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileMapper {
    public ProfileDto profileToDto(Profile profile){

        ProfileDto profileDto = new ProfileDto();
        if(profile!=null){
            BeanUtils.copyProperties(profile, profileDto);

            return profileDto;
        }
        return null;
    }

    public Profile profileDtoToProfile(ProfileDto profileDto){

        Profile profile = new Profile();
        if(profileDto!=null){
            BeanUtils.copyProperties(profileDto, profile);

            return profile;
        }
     return null;
    }
}
