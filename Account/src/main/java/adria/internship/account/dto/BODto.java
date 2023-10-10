package adria.internship.account.dto;


import adria.internship.account.enums.Sexe;
import adria.internship.account.enums.StatutContrat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BODto {
    private Long id;
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String matricule;
    private String type;
    private String password;
    private String email;
    private String CIN;
    private String adresse;
    private Date dateNaissance;
    private StatutContrat statut;
    private Sexe sexe;
    private VilleDto villeDto;
    private AgenceDto agenceDto;
    private AdminDto adminDto;
    private ProfileDto profileDto;



}
