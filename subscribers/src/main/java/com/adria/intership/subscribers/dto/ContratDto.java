package com.adria.intership.subscribers.dto;

import adria.internship.enums.Statut;
import adria.internship.enums.TypeContrat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor @ToString
public class ContratDto {
    private String id;

    private Date dateActivation;
    private Date dateCreation;
    private Statut statut;
    private int nbMaxTransfert;
    private int nbMinTransfert;

    private TypeContrat typeContrat;

    private AbonneDto abonnes;

}
