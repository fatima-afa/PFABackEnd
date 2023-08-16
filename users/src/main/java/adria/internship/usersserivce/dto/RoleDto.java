package adria.internship.usersserivce.dto;

import adria.internship.usersserivce.entities.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private int id;
    private String role;
    private ProfileDto profileDto;
}
