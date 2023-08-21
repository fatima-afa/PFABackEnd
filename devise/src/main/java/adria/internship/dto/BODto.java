package adria.internship.dto;


import adria.internship.enums.Sexe;
import adria.internship.enums.Statut;
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

    private String password;
    private String email;
    private String CIN;
    private String adresse;
    private Date dateNaissance;
    private Statut statut;
    private Sexe sexe;
    private VilleDto villeDto;
    private AgenceDto agenceDto;
    private AdminDto adminDto;
    private ProfileDto profileDto;

}
