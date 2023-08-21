package adria.internship.usersserivce.services;

import adria.internship.usersserivce.dto.ProfileDto;
import adria.internship.usersserivce.entities.Profile;
import adria.internship.usersserivce.mappers.ProfileMapper;
import adria.internship.usersserivce.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class ProfileServiceImpl implements ProfileService {
    private ProfileMapper profileMapper;
    private ProfileRepository profileRepository;
    @Override
    public ProfileDto saveprofile(ProfileDto profileDto) {
        Profile profile=profileRepository.save(profileMapper.profileDtoToProfile(profileDto));
        return profileMapper.profileToDto(profile);
    }
}
