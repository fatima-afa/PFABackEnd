package adria.internship.entities;

import adria.internship.enums.Sexe;
import adria.internship.enums.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "TYPE",length = 6)
public abstract class User implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String nom;
    protected String prenom;
    protected String nomUtilisateur;
    protected String password;
    protected String email;
    protected String CIN;
    protected String adresse;
    protected Date dateNaissance;

    @Enumerated(EnumType.STRING)
    protected Statut statut;

    @Enumerated(EnumType.STRING)
    protected Sexe sexe;
    @ManyToOne
    protected Ville ville;
    @ManyToOne
    protected Agence agence;
    @ManyToOne
    protected Profile profile;


}
