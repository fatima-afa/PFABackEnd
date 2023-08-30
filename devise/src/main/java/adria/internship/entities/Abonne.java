package adria.internship.entities;

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

//    @ManyToOne
//    private List<Contrat> contrats;
}
