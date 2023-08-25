package adria.internship.dto;



import adria.internship.enums.Statut;
import lombok.*;

import java.util.List;

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
    private List<PaysDto> pays;

}
