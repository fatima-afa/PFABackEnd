package adria.internship.usersserivce.dto;

import adria.internship.usersserivce.entities.Admin;
import adria.internship.usersserivce.entities.Agence;
import adria.internship.usersserivce.entities.Profile;
import adria.internship.usersserivce.entities.Ville;
import adria.internship.usersserivce.enums.Sexe;
import adria.internship.usersserivce.enums.Statut;

import java.util.Date;

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
    private Ville ville;
    private Agence agence;
    private Admin admin;
    private Profile profile;

}
