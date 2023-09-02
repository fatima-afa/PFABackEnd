package com.example.contracts.dto;

import com.example.contracts.enums.StatutContrat;
import com.example.contracts.enums.TypeContrat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratDto {
    private String id;
    private Date dateActivation;
    private Date dateCreation;
    private StatutContrat statut;
    private int nbMaxTransfert;
    private int nbMinTransfert;
    private TypeContrat typeContrat;
  //  private List<Abonne> abonnes;
    private BODto boDto;
}
