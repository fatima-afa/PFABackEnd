package adria.internship.account.dto;


import adria.internship.account.enums.Sexe;
import adria.internship.account.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AbonneDto {
    private Long id;
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String matricule;

    private String password;
    private String email;
    private String CIN;
    private String adresse;
    private Date dateNaissance;

    private Statut statut;
    private Sexe sexe;


    private BODto boDto;
   // private List<MessageDto> messages;
   // private List<CompteDto> comptes;
   // private List<ContratDto> contrats;
}
