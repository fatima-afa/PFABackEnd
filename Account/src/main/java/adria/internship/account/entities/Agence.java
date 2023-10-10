package adria.internship.account.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String intituleAgence;
    private Long code;
    @Column(nullable = true)
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<User> users;
    @ManyToOne
    private Ville ville;

}
