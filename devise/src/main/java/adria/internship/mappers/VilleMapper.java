package adria.internship.mappers;


import adria.internship.dto.VilleDto;
import adria.internship.entities.Ville;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VilleMapper {
    private PaysMapper paysMapper;
    public VilleDto villeToDto(Ville ville){

        VilleDto villeDto = new VilleDto();
        if(ville!=null){
            BeanUtils.copyProperties(ville, villeDto);
            if(ville.getPays()!=null)
                villeDto.setPaysDto(paysMapper.paysToDto(ville.getPays()));
            else
                villeDto.setPaysDto(null);
            return villeDto;
        }
        return null;

    }

    public Ville villeDtoToVille(VilleDto villeDto){

        Ville ville = new Ville();
        if(villeDto!=null){
            BeanUtils.copyProperties(villeDto, ville);
            if(villeDto.getPaysDto()!=null)
                ville.setPays(paysMapper.paysDtoToPays(villeDto.getPaysDto()));
            else
                ville.setPays(null);
            return ville;
        }
        return null;
    }
}
