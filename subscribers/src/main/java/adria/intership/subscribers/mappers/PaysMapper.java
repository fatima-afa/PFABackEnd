package adria.intership.subscribers.mappers;


import adria.intership.subscribers.dto.PaysDto;
import adria.intership.subscribers.entities.Pays;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaysMapper {
    private DeviseMapper deviseMapper;

    public PaysDto paysToDto(Pays pays) {
        if (pays != null) {
            PaysDto paysDto = new PaysDto();

//        if(pays!=null){
//            paysDto.setNom(pays.getNom());
//            paysDto.setId(pays.getId());
//            return paysDto;
//        }

            BeanUtils.copyProperties(pays, paysDto);
            if (pays.getDevise() != null)
                paysDto.setDeviseDto(deviseMapper.deviseToDto(pays.getDevise()));
            else
                paysDto.setDeviseDto(null);
            return paysDto;
        }
        return null;
    }

    public Pays paysDtoToPays(PaysDto paysDto) {
        Pays pays = new Pays();
//        if (paysDto!=null){
//            pays.setNom(paysDto.getNom());
//            pays.setId(paysDto.getId());
//            return pays;
//        }

        if (paysDto != null) {
            BeanUtils.copyProperties(paysDto, pays);

            if(paysDto.getDeviseDto()!=null)
                pays.setDevise(deviseMapper.deviseDtoToDevise(paysDto.getDeviseDto()));
            else
                pays.setDevise(null);
            return pays;
        }
        return null;
    }
}
