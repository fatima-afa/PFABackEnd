package adria.internship.account.entities;

import adria.internship.account.enums.TypeMouvement;
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
public class Mouvenemt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    private String code;
    private Date date;
    private TypeMouvement typeMouvement;
    @ManyToOne
    private Compte compte;
}
