package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.AdminDto;
import adria.internship.usersserivce.entities.Admin;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminMapper {

    private VilleMapper villeMapper;
    private AgenceMapper agenceMapper;
    private ProfileMapper profileMapper;

    public AdminDto adminToDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        BeanUtils.copyProperties(admin, adminDto);
        adminDto.setVilleDto(villeMapper.villeToDto(admin.getVille()));
        adminDto.setAgenceDto(agenceMapper.agenceToDto(admin.getAgence()));
        adminDto.setProfileDto(profileMapper.profileToDto(admin.getProfile()));
        return adminDto;
    }

    public Admin adminDtoToAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDto, admin);
        admin.setVille(villeMapper.villeDtoToVille(adminDto.getVilleDto()));
        admin.setAgence(agenceMapper.agenceDtoToAgence(adminDto.getAgenceDto()));
        admin.setProfile(profileMapper.profileDtoToProfile(adminDto.getProfileDto()));
        return admin;
    }
}
