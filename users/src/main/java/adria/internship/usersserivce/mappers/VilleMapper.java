package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.VilleDto;
import adria.internship.usersserivce.entities.Ville;
import org.springframework.beans.BeanUtils;

public class VilleMapper {
    public VilleDto villeToDto(Ville ville){

        VilleDto villeDto = new VilleDto();
        BeanUtils.copyProperties(ville, villeDto);

        return villeDto;
    }

    public Ville villeDtoToVille(VilleDto villeDto){

        Ville ville = new Ville();
        BeanUtils.copyProperties(villeDto, ville);

        return ville;
    }
}
