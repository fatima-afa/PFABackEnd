package adria.internship.dto;


import adria.internship.enums.Sexe;
import adria.internship.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor @ToString
public class AbonneDto {
    private Long id;
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String matricule;
    private String token;
    private String password;
    private String email;
    private String CIN;
    private String adresse;
    private Date dateNaissance;

    private Statut statut;
    private Sexe sexe;


    private BODto bo;
    private MessageDto messages;
    private CompteDto comptes;
    private ContratDto contrats;
}
