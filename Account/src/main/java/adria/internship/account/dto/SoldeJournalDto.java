package adria.internship.account.dto;

import adria.internship.account.entities.Compte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SoldeJournalDto {
    private int id;
    private Double montant;
    private Date date;
    private CompteDto compteDto;
}
