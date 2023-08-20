package adria.internship.usersserivce.services;

import adria.internship.usersserivce.dto.RoleDto;
import adria.internship.usersserivce.entities.Role;

public interface RoleService {
    RoleDto saveRole(RoleDto roleDto);

}
