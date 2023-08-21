package adria.internship.usersserivce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pays {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Column(nullable = true)
    @OneToMany(mappedBy = "pays", fetch = FetchType.LAZY)
    private List<Ville> villes;
   // @ManyToOne
    //private Devise devise;
}
