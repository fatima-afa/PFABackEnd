package adria.internship.account.mappers;

import adria.internship.account.dto.ContratDto;
import adria.internship.account.entities.Contrat;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContratMapper {
    private BOMapper boMapper;
public ContratDto contratToDto(Contrat contrat){
    ContratDto contratDto=new ContratDto();
    if(contrat!=null){
        BeanUtils.copyProperties(contrat,contratDto);
        if(contrat.getBo()!=null){
            contratDto.setBoDto(boMapper.boToDto(contrat.getBo()));
        }
        else {
            contratDto.setBoDto(null);
        }
        return contratDto;
    }
    return null;

}

    public Contrat DtoTocontrat(ContratDto contratDto){
        Contrat contrat=new Contrat();
        if(contratDto!=null){
            BeanUtils.copyProperties(contratDto,contrat);
            if(contratDto.getBoDto()!=null){
                contrat.setBo(boMapper.boDtoTobo(contratDto.getBoDto()));
            }
            else {
                contrat.setBo(null);
            }
            return contrat;
        }
        return null;

    }


}
