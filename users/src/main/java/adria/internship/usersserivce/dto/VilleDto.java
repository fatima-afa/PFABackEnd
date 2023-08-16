package adria.internship.usersserivce.dto;
import adria.internship.usersserivce.entities.Pays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VilleDto{
    private Long id;
    private String nom;
    private PaysDto paysDto;

}
