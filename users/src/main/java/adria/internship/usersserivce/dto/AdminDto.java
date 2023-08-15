package adria.internship.usersserivce.dto;

import adria.internship.usersserivce.entities.*;
import adria.internship.usersserivce.enums.Sexe;
import adria.internship.usersserivce.enums.Statut;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminDto {
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
    private List<Admin> idAdmins;
    private List<Devise> devises;
    private List<ParameterGlobale> parameterGlobales;
    private List<BO> bos;
}
