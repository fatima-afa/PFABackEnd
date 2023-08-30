package adria.internship.usersserivce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity @AllArgsConstructor
@Data @NoArgsConstructor @ToString
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numCompte;
    private double solde;
    private double frais;
    private Date dateOuverture;
    private Date dateCloture;
    private String RIB;


    @ManyToOne
    @JoinColumn(name = "abonne_id")
    private Abonne abonne;

}
