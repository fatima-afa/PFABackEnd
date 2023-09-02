package adria.internship.usersserivce.controllers;

import adria.internship.usersserivce.dto.AgenceDto;
import adria.internship.usersserivce.exceptions.AgenceNotFound;
import adria.internship.usersserivce.services.AgenceServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Builder
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class AgenceController {
    private AgenceServiceImpl agenceService;

    @GetMapping("/agences")
    public ResponseEntity<List<AgenceDto>> getAllAgences(){
        List<AgenceDto> agenceDtos=agenceService.allAgences();
        return new ResponseEntity<>(agenceDtos, HttpStatus.OK);
    }
    @GetMapping("/agence/{id}")
    public ResponseEntity<AgenceDto> getAgenceById(@PathVariable Long id){
        try{
            AgenceDto agenceDto=agenceService.getAgence(id);
            return new ResponseEntity<>(agenceDto,HttpStatus.OK);
        }catch (AgenceNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }


}
