package adria.internship.mappers;

import adria.internship.dto.RoleDto;
import adria.internship.entities.Role;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleMapper {

    private ProfileMapper profileMapper;
    public RoleDto roleToDto(Role role) {
        RoleDto roleDto = new RoleDto();
        if(role!=null){
            BeanUtils.copyProperties(role, roleDto);
            if(role.getProfile()!=null)
                roleDto.setProfileDto(profileMapper.profileToDto(role.getProfile()));
            else
                roleDto.setProfileDto(null);

            return roleDto;
        }
        return null;
    }

    public Role dtoToRole(RoleDto roleDto) {
        Role role = new Role();
        if(roleDto!=null){
            BeanUtils.copyProperties(roleDto, role);
            if(roleDto.getProfileDto()!=null)
                role.setProfile(profileMapper.profileDtoToProfile(roleDto.getProfileDto()));
            else
                role.setProfile(null);
            return role;
        }
        return null;
    }
}
