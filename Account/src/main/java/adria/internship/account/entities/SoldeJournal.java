package adria.internship.account.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class SoldeJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double montant;
    private Date date;
    @ManyToOne
    private Compte compte;
}
