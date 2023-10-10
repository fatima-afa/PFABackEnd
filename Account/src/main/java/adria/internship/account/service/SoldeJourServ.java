package adria.internship.account.service;

import adria.internship.account.dto.CompteDto;
import adria.internship.account.dto.SoldeJournalDto;
import adria.internship.account.entities.SoldeJournal;

import java.util.Date;
import java.util.List;

public interface SoldeJourServ {
    SoldeJournalDto saveSoldeJour(SoldeJournalDto soldeJournalDto);
    SoldeJournalDto getSoldeJournal(SoldeJournalDto soldeJournalDto);
    List<SoldeJournal> getAllSoldeJournal();
}
