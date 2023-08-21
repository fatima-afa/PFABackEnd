package adria.internship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterGlobaleDto {
    private Long id;
    private String nom;
    private Long valeur;
    private AdminDto adminDto;
}
