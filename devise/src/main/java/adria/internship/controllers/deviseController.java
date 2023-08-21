package adria.internship.controllers;

import adria.internship.dto.DeviseDto;
import adria.internship.entities.Devise;
import adria.internship.exceptions.DeviseNotFound;
import adria.internship.services.deviseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devise")
public class deviseController {

    private deviseServiceImpl deviseService;

    @Autowired
    public deviseController(deviseServiceImpl deviseService) {
        this.deviseService = deviseService;
    }

    //done
    @PostMapping("/add")
    public ResponseEntity<DeviseDto> saveDevise(@RequestBody DeviseDto deviseDto) {
        DeviseDto savedDevise = deviseService.saveDevise(deviseDto);
        return new ResponseEntity<>(savedDevise, HttpStatus.CREATED);
    }

    //done
    @GetMapping("/{id}")
    public ResponseEntity<DeviseDto> getDevise(@PathVariable Long id) {
        try {
            DeviseDto deviseDto = deviseService.getDevise(id);
            return new ResponseEntity<>(deviseDto, HttpStatus.OK);
        } catch (DeviseNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<DeviseDto> updateDevise(@RequestBody DeviseDto deviseDto) {
        try {
            DeviseDto updatedDevise = deviseService.updateDevise(deviseDto);
            return new ResponseEntity<>(updatedDevise, HttpStatus.OK);
        } catch (DeviseNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //done
    @GetMapping("/all")
    public ResponseEntity<List<DeviseDto>> listDevises() {
        List<DeviseDto> devises = deviseService.listDevise();
        return new ResponseEntity<>(devises, HttpStatus.OK);
    }
}
