package adria.internship.usersserivce.entities;

import adria.internship.usersserivce.enums.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Devise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String code;
    private Long numero;
    private Double tauxEchange;
    private Statut statutDevise;
   // @Column(nullable = true)
   // @OneToMany(mappedBy = "devise", fetch = FetchType.LAZY)
    //private  List<Pays> pays;
    //@ManyToOne
    //private Admin admin;


}
