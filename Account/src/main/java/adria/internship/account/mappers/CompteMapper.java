package adria.internship.account.mappers;

import adria.internship.account.dto.CompteDto;
import adria.internship.account.entities.Compte;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompteMapper {
    private AbonneMappers abonneMappers;
    public CompteDto compteToDto(Compte compte){
        CompteDto compteDto=new CompteDto();
        if(compte!=null){
            BeanUtils.copyProperties(compte,compteDto);
            if(compte.getAbonne()!=null){
                compteDto.setAbonneDto(abonneMappers.abonneToDto(compte.getAbonne()));
            }
            else
                compteDto.setAbonneDto(null);
        return compteDto;
        }
        return null;
    }
    public Compte compteDtoToCompte(CompteDto compteDto){
        Compte compte=new Compte();
        if(compteDto!=null){
            BeanUtils.copyProperties(compteDto,compte);
            if(compteDto.getAbonneDto()!=null){
                compte.setAbonne(abonneMappers.abonneDtoToAbonne(compteDto.getAbonneDto()));
            }
            else
                compte.setAbonne(null);
       return compte;
        }
        return null;
    }
}
