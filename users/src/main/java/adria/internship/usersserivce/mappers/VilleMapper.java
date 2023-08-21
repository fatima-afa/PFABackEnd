package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.VilleDto;
import adria.internship.usersserivce.entities.Ville;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VilleMapper {
    private PaysMapper paysMapper;
    public VilleDto villeToDto(Ville ville){

        VilleDto villeDto = new VilleDto();
        BeanUtils.copyProperties(ville, villeDto);
        villeDto.setPaysDto(paysMapper.paysToDto(ville.getPays()));
        return villeDto;
    }

    public Ville villeDtoToVille(VilleDto villeDto){

        Ville ville = new Ville();
        BeanUtils.copyProperties(villeDto, ville);
        ville.setPays(paysMapper.paysDtoToPays(villeDto.getPaysDto()));
        return ville;
    }
}
