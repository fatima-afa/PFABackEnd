package adria.internship.account.mappers;

import adria.internship.account.dto.SoldeJournalDto;
import adria.internship.account.entities.SoldeJournal;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SoldeJournalMapper {
    private CompteMapper compteMapper;

    public SoldeJournalDto soldeJournalToDto(SoldeJournal soldeJournal){
        SoldeJournalDto soldeJournalDto=new SoldeJournalDto();
        if(soldeJournal!=null){
            BeanUtils.copyProperties(soldeJournal,soldeJournalDto);
            if(soldeJournal.getCompte()!=null)
                soldeJournalDto.setCompteDto(compteMapper.compteToDto(soldeJournal.getCompte()));
            else
                soldeJournalDto.setCompteDto(null);
            return soldeJournalDto;
        }

        return null;
    }

    public SoldeJournal soldeJournalDtoToSolde(SoldeJournalDto soldeJournalDto){
        SoldeJournal soldeJournal=new SoldeJournal();
        if(soldeJournalDto!=null){
            BeanUtils.copyProperties(soldeJournalDto,soldeJournal);
            if(soldeJournalDto.getCompteDto()!=null)
                soldeJournal.setCompte(compteMapper.compteDtoToCompte(soldeJournalDto.getCompteDto()));
            else
                soldeJournal.setCompte(null);
            return soldeJournal;
        }

        return null;
    }
}
