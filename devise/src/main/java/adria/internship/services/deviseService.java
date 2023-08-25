package adria.internship.services;

import adria.internship.dto.DeviseDto;
import adria.internship.dto.PaysDto;
import adria.internship.entities.Devise;
import adria.internship.exceptions.DeviseNotFound;

import java.util.List;

public interface deviseService {

    //done
//    DeviseDto saveDevise(DeviseDto deviseDto);

    PaysDto saveDeviseWithPays(PaysDto paysDto);

    //done
    DeviseDto getDevise(Long id) throws DeviseNotFound;

    DeviseDto updateDevise(DeviseDto deviseDto) throws DeviseNotFound;
    //done
    List<DeviseDto> listDevise();

    List<PaysDto> listDeviseWithPays();

    DeviseDto patchDevise(Long id, DeviseDto partialDeviseDto) throws DeviseNotFound;

    PaysDto getDeviseByPays(Long id) throws DeviseNotFound;

//    PaysDto getDeviseByPays(Long id) throws DeviseNotFound;

    List<DeviseDto> searchDevise(Long id);

}
