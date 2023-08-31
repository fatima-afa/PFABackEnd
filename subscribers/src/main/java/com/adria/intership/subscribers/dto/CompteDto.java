package com.adria.intership.subscribers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompteDto {
    private Long id;

    private String numCompte;
    private double solde;
    private double frais;
    private Date dateOuverture;
    private Date dateCloture;
    private String RIB;

    private AbonneDto abonne;
}
