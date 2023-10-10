package adria.internship.account.dto;

import adria.internship.account.enums.TypeMouvement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MouvementDto {
    private int id;
    private String libelle;
    private String code;
    private Date date;
    private TypeMouvement typeMouvement;
    private CompteDto compteDto;
}
