package adria.internship.usersserivce.dto;

import adria.internship.usersserivce.entities.Admin;
import adria.internship.usersserivce.entities.Pays;
import adria.internship.usersserivce.enums.Statut;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviseDto {
    private Long id;
    private String libelle;
    private String code;
    private Long numero;
    private Double tauxEchange;
    private Statut statutDevise;
    private AdminDto adminDto;
}
