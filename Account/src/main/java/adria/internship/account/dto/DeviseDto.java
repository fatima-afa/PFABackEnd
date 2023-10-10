package adria.internship.account.dto;

import adria.internship.account.enums.Statut;
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
