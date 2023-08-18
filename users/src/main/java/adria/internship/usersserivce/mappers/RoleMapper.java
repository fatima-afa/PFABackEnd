package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.RoleDto;
import adria.internship.usersserivce.entities.Role;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleMapper {

    private ProfileMapper profileMapper;
    public RoleDto roleToDto(Role role) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(role, roleDto);
        roleDto.setProfileDto(profileMapper.profileToDto(role.getProfile()));
        return roleDto;
    }

    public Role dtoToRole(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        role.setProfile(profileMapper.profileDtoToProfile(roleDto.getProfileDto()));
        return role;
    }
}
