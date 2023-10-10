package adria.internship.account.service;

import adria.internship.account.Reposetories.CompteRepo;
import adria.internship.account.Reposetories.SoldeJourRepo;
import adria.internship.account.dto.CompteDto;
import adria.internship.account.dto.SoldeJournalDto;
import adria.internship.account.entities.SoldeJournal;
import adria.internship.account.mappers.CompteMapper;
import adria.internship.account.mappers.SoldeJournalMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class SoldeJourServImpl implements SoldeJourServ {
    private SoldeJourRepo soldeJourRepo;
    private SoldeJournalMapper soldeJournalMapper;
    private CompteMapper compteMapper;
    private CompteRepo compteRepo;
    @Override
    public SoldeJournalDto saveSoldeJour(SoldeJournalDto soldeJournalDto) {
        SoldeJournal soldeJournal=soldeJourRepo.save(soldeJournalMapper.soldeJournalDtoToSolde(soldeJournalDto));
        soldeJournal.setCompte(compteMapper.compteDtoToCompte(soldeJournalDto.getCompteDto()));
        return soldeJournalMapper.soldeJournalToDto(soldeJournal);
    }

    @Override
    public SoldeJournalDto getSoldeJournal(SoldeJournalDto soldeJournalDto) {
            //TODO
        return null;
    }

    @Override
    public List<SoldeJournal> getAllSoldeJournal() {
        //TODO
        return null;
    }
}
