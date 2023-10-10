package adria.internship.account.mappers;

import adria.internship.account.dto.RechargeteleDto;
import adria.internship.account.entities.RechargeTele;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

@Service
@AllArgsConstructor
public class RechargeTeleMapper {
    private CompteMapper compteMapper;
    private Operateurmappers operateurmappers;
    public RechargeTele RechargeTeleDtoToRecharge(RechargeteleDto rechargeteleDto){
        RechargeTele rechargeTele=new RechargeTele();
        if(rechargeteleDto!=null){
            BeanUtils.copyProperties(rechargeteleDto,rechargeTele);
            if (rechargeteleDto.getCompteDto()!=null)
                rechargeTele.setCompte(compteMapper.compteDtoToCompte(rechargeteleDto.getCompteDto()));

            else
                rechargeTele.setCompte(null);
            if (rechargeteleDto.getOperateurDto()!=null)
                rechargeTele.setOperateur(operateurmappers.operateurDtoToOperateur(rechargeteleDto.getOperateurDto()));
            else
                rechargeTele.setOperateur(null);
      return rechargeTele;
        }
        return null;
    }

    public RechargeteleDto RechargeTeleToDto(RechargeTele rechargetele){
        RechargeteleDto rechargeteleDto=new RechargeteleDto();
        if(rechargetele!=null){
            BeanUtils.copyProperties(rechargetele,rechargeteleDto);
            if (rechargetele.getCompte()!=null)
                rechargeteleDto.setCompteDto(compteMapper.compteToDto(rechargetele.getCompte()));

            else
                rechargetele.setCompte(null);
            if (rechargetele.getOperateur()!=null)
                rechargeteleDto.setOperateurDto(operateurmappers.operatorToDto(rechargetele.getOperateur()));
            else
                rechargeteleDto.setOperateurDto(null);

            return rechargeteleDto;
        }
        return null;
    }
}
