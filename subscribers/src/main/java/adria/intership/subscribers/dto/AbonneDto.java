package adria.intership.subscribers.dto;


import adria.intership.subscribers.enums.Sexe;
import adria.intership.subscribers.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor @ToString
public class AbonneDto {
    private Long id;
    private String nom;
    private String prenom;
    private String nomUtilisateur;
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
