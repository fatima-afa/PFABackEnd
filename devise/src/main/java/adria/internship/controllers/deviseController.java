package adria.internship.controllers;

import adria.internship.dto.DeviseDto;
import adria.internship.dto.PaysDto;
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
    public ResponseEntity<PaysDto> saveDevise(@RequestBody PaysDto paysDto) {
        PaysDto savedpays = deviseService.saveDeviseWithPays(paysDto);
        return new ResponseEntity<>(savedpays, HttpStatus.CREATED);
    }

//    public ResponseEntity<DeviseDto> saveDevise(@RequestBody DeviseDto deviseDto) {
//        DeviseDto savedDevise = deviseService.saveDevise(deviseDto);
//        return new ResponseEntity<>(savedDevise, HttpStatus.CREATED);
//    }

    //done
    @GetMapping("/{id}")
    public ResponseEntity<PaysDto> getDevise(@PathVariable Long id) {
        try {
            PaysDto paysDto = deviseService.getDeviseByPays(id);
            return new ResponseEntity<>(paysDto, HttpStatus.OK);
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


//    @GetMapping("/all")
    public ResponseEntity<List<DeviseDto>> listDevises() {
        List<DeviseDto> devises = deviseService.listDevise();
        return new ResponseEntity<>(devises, HttpStatus.OK);
    }

    //done
    @GetMapping("/all")
    public ResponseEntity<List<PaysDto>> listDevisesWithPays() {
        List<PaysDto> devises = deviseService.listDeviseWithPays();
        return new ResponseEntity<>(devises, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DeviseDto> patchDevise(@PathVariable Long id, @RequestBody DeviseDto deviseDto) {
        try {
            DeviseDto patchedDevise = deviseService.patchDevise(id, deviseDto);
            return new ResponseEntity<>(patchedDevise, HttpStatus.OK);
        } catch (DeviseNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
