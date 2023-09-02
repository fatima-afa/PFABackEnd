package com.example.contracts.mappers;


import com.example.contracts.dto.AdminDto;
import com.example.contracts.entities.Admin;
import com.example.contracts.mappers.AgenceMapper;
import com.example.contracts.mappers.ProfileMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminMapper {

    private AgenceMapper agenceMapper;
    private ProfileMapper profileMapper;

    public AdminDto adminToDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        if(admin!=null){
            BeanUtils.copyProperties(admin, adminDto);
            if(admin.getAgence()!=null)
                 adminDto.setAgenceDto(agenceMapper.agenceToDto(admin.getAgence()));
            else
                adminDto.setAgenceDto(null);
            if(adminDto.getProfileDto()!=null)
                adminDto.setProfileDto(profileMapper.profileToDto(admin.getProfile()));
            else
                adminDto.setProfileDto(null);
            return adminDto;
        }

       // adminDto.setVilleDto(villeMapper.villeToDto(admin.getVille()));

        return null;
    }

    public Admin adminDtoToAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        if(adminDto!=null){
            BeanUtils.copyProperties(adminDto, admin);
            //  admin.setVille(villeMapper.villeDtoToVille(adminDto.getVilleDto()));
            if(adminDto.getAgenceDto()!=null)
                 admin.setAgence(agenceMapper.agenceDtoToAgence(adminDto.getAgenceDto()));
            else
                admin.setAgence(null);
            if (adminDto.getProfileDto()!=null)
                admin.setProfile(profileMapper.profileDtoToProfile(adminDto.getProfileDto()));
            else
                admin.setProfile(null);
            return admin;

        }

        return null;
    }
}
