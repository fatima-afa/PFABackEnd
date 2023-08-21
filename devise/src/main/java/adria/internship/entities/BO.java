package adria.internship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class BO extends User {
    private String matricule;
    @ManyToOne
    private Admin admin;
}
