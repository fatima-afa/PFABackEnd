package adria.internship.account.mappers;

import adria.internship.account.dto.BODto;
import adria.internship.account.entities.BO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BOMapper {
    private VilleMapper villeMapper;
    private AgenceMapper agenceMapper;
    private ProfileMapper profileMapper;
    private AdminMapper adminMapper;
    public BODto boToDto(BO bo){

        BODto boDto = new BODto();
        if(bo!=null){
            BeanUtils.copyProperties(bo, boDto);

            if(bo.getVille()!=null)
                boDto.setVilleDto(villeMapper.villeToDto(bo.getVille()));
            else
                boDto.setVilleDto(null);

            if(bo.getAdmin()!=null)
                boDto.setAdminDto(adminMapper.adminToDto(bo.getAdmin()));
            else
                boDto.setAdminDto(null);

            if(bo.getProfile()!=null)
                boDto.setProfileDto(profileMapper.profileToDto(bo.getProfile()));
            else
                boDto.setProfileDto(null);

            if(bo.getAgence()!=null)
                boDto.setAgenceDto(agenceMapper.agenceToDto(bo.getAgence()));
            else
                boDto.setAgenceDto(null);

            return boDto;
        }
    return null;
    }

    public BO boDtoTobo(BODto boDto){
        BO bo=new BO();
        if(boDto!=null){
            BeanUtils.copyProperties(boDto, bo);

            if(boDto.getVilleDto()!=null)
                bo.setVille(villeMapper.villeDtoToVille(boDto.getVilleDto()));
            else
                bo.setVille(null);

            if(boDto.getAdminDto()!=null)
                bo.setAdmin(adminMapper.adminDtoToAdmin(boDto.getAdminDto()));
            else
                bo.setAdmin(null);

            if(boDto.getProfileDto()!=null)
                bo.setProfile(profileMapper.profileDtoToProfile(boDto.getProfileDto()));
            else
                bo.setProfile(null);

            if(boDto.getAgenceDto()!=null)
                bo.setAgence(agenceMapper.agenceDtoToAgence(boDto.getAgenceDto()));
            else
                bo.setAgence(null);

            return bo;
        }

        return null;
    }

}
