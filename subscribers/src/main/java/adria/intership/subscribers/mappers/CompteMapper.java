package adria.intership.subscribers.mappers;

import adria.intership.subscribers.dto.CompteDto;
import adria.intership.subscribers.entities.Compte;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompteMapper {

    public CompteDto compteToDto(Compte compte) {
        CompteDto compteDto = new CompteDto();
        if (compte != null) {
            BeanUtils.copyProperties(compte, compteDto);
        }
        return compteDto;
    }

    public Compte compteDtoToCompte(CompteDto compteDto) {
        Compte compte = new Compte();
        if (compteDto != null) {
            BeanUtils.copyProperties(compteDto, compte);
        }
        return compte;
    }
}
