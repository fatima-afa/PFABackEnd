package adria.internship.services;

import adria.internship.dto.DeviseDto;
import adria.internship.entities.Devise;
import adria.internship.exceptions.DeviseNotFound;

import java.util.List;

public interface deviseService {

    //done
    DeviseDto saveDevise(DeviseDto deviseDto);
    //done
    DeviseDto getDevise(Long id) throws DeviseNotFound;

    DeviseDto updateDevise(DeviseDto deviseDto) throws DeviseNotFound;
    //done
    List<DeviseDto> listDevise();
    List<DeviseDto> searchDevise(Long id);

}
