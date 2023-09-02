package com.example.contracts.dto;
import com.example.contracts.dto.AdminDto;
import com.example.contracts.dto.AgenceDto;
import com.example.contracts.dto.ProfileDto;
import com.example.contracts.dto.VilleDto;
import com.example.contracts.enums.Sexe;
import com.example.contracts.enums.StatutContrat;
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
