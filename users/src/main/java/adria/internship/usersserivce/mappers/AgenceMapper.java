package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.AgenceDto;
import adria.internship.usersserivce.entities.Agence;
import org.springframework.beans.BeanUtils;

public class AgenceMapper {
    private VilleMapper villeMapper;

    public AgenceDto agenceToDto(Agence agence){

        AgenceDto agenceDto = new AgenceDto();
        BeanUtils.copyProperties(agence, agenceDto);
        agenceDto.setVilleDto(villeMapper.villeToDto(agence.getVille()));
        return agenceDto;
    }

    public Agence agenceDtoToAgence(AgenceDto agenceDto){

        Agence agence = new Agence();
        BeanUtils.copyProperties(agenceDto, agence);
        agence.setVille(villeMapper.villeDtoToVille(agenceDto.getVilleDto()));
        return agence;
    }
}
