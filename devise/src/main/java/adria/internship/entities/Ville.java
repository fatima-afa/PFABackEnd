package adria.internship.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    private Pays pays;
    @Column(nullable = true)
    @OneToMany(mappedBy = "ville", fetch = FetchType.LAZY)
    private List<Agence> agences;
    @OneToMany(mappedBy = "ville", fetch = FetchType.LAZY)
    private List<BO> bos;


}
