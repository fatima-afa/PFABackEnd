package adria.internship.usersserivce.services;

import adria.internship.usersserivce.dto.PaysDto;
import adria.internship.usersserivce.dto.VilleDto;
import adria.internship.usersserivce.entities.Pays;

import java.util.List;

public interface PaysVilleService {
        VilleDto saveVille(VilleDto villeDto);
        List<VilleDto> getAllVilles();
        PaysDto savePays(PaysDto paysDto);
        List<PaysDto> getAllPays();

}
