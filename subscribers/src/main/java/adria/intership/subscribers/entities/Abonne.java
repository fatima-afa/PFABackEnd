package adria.intership.subscribers.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor @ToString
public class Abonne extends User{

    @ManyToOne
    @JoinColumn(name = "bo_id")
    private BO bo;

    @OneToMany(mappedBy = "abonne",fetch = FetchType.LAZY)
    private List<Message> messages;

    @OneToMany(mappedBy = "abonne",fetch = FetchType.LAZY)
    private List<Compte> comptes;

    @ManyToMany
    @JoinTable(
            name = "abonne_contrat",
            joinColumns = @JoinColumn(name = "abonne_id"),
            inverseJoinColumns = @JoinColumn(name = "contrat_id")
    )
    private List<Contrat> contrats;
}
