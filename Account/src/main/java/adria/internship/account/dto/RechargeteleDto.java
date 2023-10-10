package adria.internship.account.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RechargeteleDto {
    private int id;
    private int montant;
    private String numTele;
    private Operateurdto operateurDto;
    private CompteDto compteDto;
}
