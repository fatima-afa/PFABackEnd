package adria.internship.account.mappers;


import adria.internship.account.dto.PaysDto;
import adria.internship.account.entities.Pays;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaysMapper {
    //private DeviseMapper deviseMapper;

    public PaysDto paysToDto(Pays pays){
        PaysDto paysDto = new PaysDto();
        if(pays!=null){
            paysDto.setNom(pays.getNom());
            paysDto.setId(pays.getId());
           return paysDto;
        }

    //    BeanUtils.copyProperties(pays, paysDto);
       // paysDto.setDeviseDto(deviseMapper.deviseToDto(pays.getDevise()));
        return null;
    }

    public Pays paysDtoToPays(PaysDto paysDto){
        Pays pays = new Pays();
        if ((paysDto!=null)){
            pays.setNom(paysDto.getNom());
            pays.setId(paysDto.getId());
            return pays;
        }

     //   BeanUtils.copyProperties(paysDto, pays);
       // pays.setDevise(deviseMapper.deviseDtoToDevise(paysDto.getDeviseDto()));
        return null;
    }
}
