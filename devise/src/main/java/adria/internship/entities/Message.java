package adria.internship.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sujet;
    private String Message;

    @ManyToOne
    @JoinColumn(name = "bo_id")
    private BO bo;

    @ManyToOne
    @JoinColumn(name = "abonne_id")
    private Abonne abonne;
}
