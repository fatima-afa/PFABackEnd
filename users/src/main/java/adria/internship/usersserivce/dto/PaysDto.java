package adria.internship.usersserivce.dto;

import adria.internship.usersserivce.entities.Devise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class PaysDto {
    private Long id;
    private String nom;
    private DeviseDto deviseDto;

}
