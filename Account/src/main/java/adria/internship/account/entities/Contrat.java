package adria.internship.account.entities;


import adria.internship.account.entities.*;

import adria.internship.account.enums.StatutContrat;
import adria.internship.account.enums.TypeContrat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Contrat {

    @Id
    private String id;

    private Date dateActivation;
    private Date dateCreation;
    private StatutContrat statut;
    private int nbMaxTransfert;
    private int nbMinTransfert;

    private TypeContrat typeContrat;

    @ManyToMany(mappedBy = "contrats")
    private List<Abonne> abonnes;

    @ManyToOne
    private BO bo;
}
