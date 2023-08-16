package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.PaysDto;
import adria.internship.usersserivce.dto.VilleDto;
import adria.internship.usersserivce.entities.Pays;
import adria.internship.usersserivce.entities.Ville;
import org.springframework.beans.BeanUtils;

public class PaysMapper {
    public PaysDto paysToDto(Pays pays){

        PaysDto paysDto = new PaysDto();
        BeanUtils.copyProperties(pays, paysDto);

        return paysDto;
    }

    public Pays paysDtoToPays(PaysDto paysDto){

        Pays pays = new Pays();
        BeanUtils.copyProperties(paysDto, pays);

        return pays;
    }
}
