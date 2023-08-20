package adria.internship.usersserivce.services;

import adria.internship.usersserivce.dto.AgenceDto;
import adria.internship.usersserivce.entities.Agence;
import adria.internship.usersserivce.exceptions.AdminNotFound;
import adria.internship.usersserivce.exceptions.AgenceNotFound;

public interface AgenceService {
    AgenceDto saveAgence(AgenceDto agenceDto);
    AgenceDto getAgence(Long id) throws AdminNotFound, AgenceNotFound;
}
