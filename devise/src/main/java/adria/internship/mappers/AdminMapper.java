package adria.internship.mappers;


import adria.internship.dto.AdminDto;
import adria.internship.entities.Admin;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminMapper {

//    private  VilleMapper villeMapper;
    private  AgenceMapper agenceMapper;
    private  ProfileMapper profileMapper;

    public AdminDto adminToDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        if (admin != null) {
            BeanUtils.copyProperties(admin, adminDto);

            if (admin.getVille() != null) {
//                adminDto.setVilleDto(villeMapper.villeToDto(admin.getVille()));
            }

            if (admin.getAgence() != null) {
                adminDto.setAgenceDto(agenceMapper.agenceToDto(admin.getAgence()));
            }

            if (admin.getProfile() != null) {
                adminDto.setProfileDto(profileMapper.profileToDto(admin.getProfile()));
            }
        }
        return adminDto;
    }

    public Admin adminDtoToAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        if (adminDto != null) {
            BeanUtils.copyProperties(adminDto, admin);

            if (adminDto.getVilleDto() != null) {
//                admin.setVille(villeMapper.villeDtoToVille(adminDto.getVilleDto()));
            }

            if (adminDto.getAgenceDto() != null) {
                admin.setAgence(agenceMapper.agenceDtoToAgence(adminDto.getAgenceDto()));
            }

            if (adminDto.getProfileDto() != null) {
                admin.setProfile(profileMapper.profileDtoToProfile(adminDto.getProfileDto()));
            }
        }
        return admin;
    }
}