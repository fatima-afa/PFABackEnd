package adria.internship.account.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class RechargeTele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int montant;
    private String numTele;
    @ManyToOne
    private Operateur operateur;
    @ManyToOne
    private Compte compte;
}
