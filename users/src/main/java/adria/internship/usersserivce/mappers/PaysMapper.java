package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.DeviseDto;
import adria.internship.usersserivce.dto.PaysDto;
import adria.internship.usersserivce.entities.Devise;
import adria.internship.usersserivce.entities.Pays;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaysMapper {
    private DeviseMapper deviseMapper;

    public PaysDto paysToDto(Pays pays){
        PaysDto paysDto = new PaysDto();
        BeanUtils.copyProperties(pays, paysDto);
        paysDto.setDeviseDto(deviseMapper.deviseToDto(pays.getDevise()));
        return paysDto;
    }

    public Pays paysDtoToPays(PaysDto paysDto){
        Pays pays = new Pays();
        BeanUtils.copyProperties(paysDto, pays);
        pays.setDevise(deviseMapper.deviseDtoToDevise(paysDto.getDeviseDto()));
        return pays;
    }
}
