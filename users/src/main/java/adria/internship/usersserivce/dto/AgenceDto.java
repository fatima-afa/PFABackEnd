package adria.internship.usersserivce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenceDto {

    private int id;
    private String intituleAgence;
    private Long code;

    private VilleDto villeDto;
}
