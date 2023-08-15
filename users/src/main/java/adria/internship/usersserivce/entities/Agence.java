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
public class Agence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String intituleAgence;
    private Long code;
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<User> users;
    @ManyToOne
    private Ville ville;

}
