package adria.intership.subscribers.services;

import adria.intership.subscribers.dto.AbonneDto;
import adria.intership.subscribers.exceptions.AbonneNotFound;

import java.util.List;

public interface AbonneService {
    //create
    AbonneDto saveAbonne (AbonneDto abonneDto);
    //read
    AbonneDto getAbonne (Long id) throws AbonneNotFound;
    //update
    AbonneDto updateAbonne(AbonneDto abonneDto) throws AbonneNotFound;
    //delete
    void deleteAbonne(Long id);
    //List de tous les abonnes
    List<AbonneDto> allAbonne();

}
