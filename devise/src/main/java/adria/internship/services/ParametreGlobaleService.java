package adria.internship.services;

import adria.internship.dto.ParameterGlobaleDto;
import adria.internship.entities.ParameterGlobale;
import adria.internship.exceptions.ParamNotFound;

import java.util.List;


public interface ParametreGlobaleService {

    //enregistre un nouveau parametre
    ParameterGlobaleDto saveParametreGlobale(ParameterGlobaleDto parameterGlobaleDto);

    //recuperer le param
    ParameterGlobaleDto getParametreGlobale(Long id) throws ParamNotFound;

    //modifier le param
    ParameterGlobaleDto updateParametreGlobale(Long id, ParameterGlobaleDto parameterGlobaleDto);

    void deleteParametreGlobale(Long id);

    List<ParameterGlobaleDto> allParametreGlobale();
}
