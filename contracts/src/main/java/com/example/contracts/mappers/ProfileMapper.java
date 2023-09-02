package com.example.contracts.mappers;


import com.example.contracts.dto.ProfileDto;
import com.example.contracts.entities.Profile;
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
