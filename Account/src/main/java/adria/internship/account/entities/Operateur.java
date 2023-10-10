package adria.internship.account.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Operateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String nomOper;
    private String logo;
    @OneToMany(mappedBy = "operateur")
    private List<RechargeTele> rechargeTeles;
}
