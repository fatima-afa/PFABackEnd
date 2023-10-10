package adria.internship.account.mappers;


import adria.internship.account.dto.AgenceDto;
import adria.internship.account.entities.Agence;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AgenceMapper {
    private VilleMapper villeMapper;

    public AgenceDto agenceToDto(Agence agence){

        AgenceDto agenceDto = new AgenceDto();
        if(agence!=null){
            BeanUtils.copyProperties(agence, agenceDto);
            if(agence.getVille()!=null)
                agenceDto.setVilleDto(villeMapper.villeToDto(agence.getVille()));
            else
                agenceDto.setVilleDto(null);

            return agenceDto;
        }
        return null;
    }

    public Agence agenceDtoToAgence(AgenceDto agenceDto){

        Agence agence = new Agence();
        if(agenceDto!=null){
            BeanUtils.copyProperties(agenceDto, agence);
            if(agenceDto.getVilleDto()!=null)
                agence.setVille(villeMapper.villeDtoToVille(agenceDto.getVilleDto()));
            else
                agence.setVille(null);
            return agence;
        }
       return null;
    }
}
