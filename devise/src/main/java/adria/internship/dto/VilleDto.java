package adria.internship.dto;
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
