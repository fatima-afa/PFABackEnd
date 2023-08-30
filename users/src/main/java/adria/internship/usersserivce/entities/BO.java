package adria.internship.usersserivce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class BO extends User {
    private String matricule;
    @ManyToOne
    private Admin admin;
    @ManyToOne
    protected Ville ville;

    @OneToMany(mappedBy = "bo",fetch = FetchType.LAZY)
    private List<Abonne> abonnes;

    @OneToMany(mappedBy = "bo",fetch = FetchType.LAZY)
    private List<Message> messages;
}
