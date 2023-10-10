package adria.internship.services;

import adria.internship.dto.DeviseDto;
import adria.internship.dto.PaysDto;
import adria.internship.entities.Devise;
import adria.internship.exceptions.DeviseNotFound;

import java.util.List;

public interface deviseService {

    //enregistrer la devise et le pays concerné
    PaysDto saveDeviseWithPays(PaysDto paysDto);

    //recupérer une devise
    DeviseDto getDevise(Long id) throws DeviseNotFound;

    //mis a jour du devise
    DeviseDto updateDevise(DeviseDto deviseDto) throws DeviseNotFound;

    //Lister tous les devise
    List<DeviseDto> listDevise();

    //liste des devises avec leurs pays
    List<PaysDto> listDeviseWithPays();

    //modifier la devise
    DeviseDto patchDevise(Long id, DeviseDto partialDeviseDto) throws DeviseNotFound;

    //recupeer un devise en utilisant le pays
    PaysDto getDeviseByPays(Long id) throws DeviseNotFound;

    List<DeviseDto> searchDevise(Long id);

}
