package adria.internship.account.mappers;

import adria.internship.account.dto.AbonneDto;
import adria.internship.account.entities.Abonne;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AbonneMappers {
    private BOMapper boMapper;
    public AbonneDto abonneToDto(Abonne abonne){
        AbonneDto abonneDto=new AbonneDto();
        if(abonne!=null){
            BeanUtils.copyProperties(abonne,abonneDto);
            if(abonne.getBo()!=null){
                abonneDto.setBoDto(boMapper.boToDto(abonne.getBo()));
            }
            else abonneDto.setBoDto(null);
        return abonneDto;
        }
        return null;
    }
    public Abonne abonneDtoToAbonne(AbonneDto abonneDto){
        Abonne abonne=new Abonne();
        if(abonneDto!=null){
            BeanUtils.copyProperties(abonneDto,abonne);
            if(abonneDto.getBoDto()!=null){
                abonne.setBo(boMapper.boDtoTobo(abonneDto.getBoDto()));
            }
            else abonneDto.setBoDto(null);

            return abonne;
        }
        return null;
    }

}
