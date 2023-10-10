package adria.internship.account.mappers;

import adria.internship.account.dto.MouvementDto;
import adria.internship.account.entities.Mouvenemt;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MouvementMapper {
    private CompteMapper compteMapper;
    public MouvementDto mouvementDtoToMouvement(Mouvenemt mouvenemt){
        MouvementDto mouvementDto=new MouvementDto();
        if(mouvenemt!=null){
            BeanUtils.copyProperties(mouvenemt,mouvementDto);
            if(mouvenemt.getCompte()!=null){
                mouvementDto.setCompteDto(compteMapper.compteToDto(mouvenemt.getCompte()));
            }
            else mouvementDto.setCompteDto(null);

            return mouvementDto;
        }
        return null;
    }

    public Mouvenemt mouvementToDto(MouvementDto mouvementDto){
        Mouvenemt mouvement=new Mouvenemt();
        if(mouvementDto!=null){
            BeanUtils.copyProperties(mouvementDto,mouvement);
            if(mouvementDto.getCompteDto()!=null){
                mouvement.setCompte(compteMapper.compteDtoToCompte(mouvementDto.getCompteDto()));
            }
            else mouvement.setCompte(null);

            return mouvement;
        }
        return null;
    }
}
