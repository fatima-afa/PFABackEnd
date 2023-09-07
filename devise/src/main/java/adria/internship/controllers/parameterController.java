package adria.internship.controllers;

import adria.internship.dto.ParameterGlobaleDto;
import adria.internship.exceptions.ParamNotFound;
import adria.internship.services.ParametreGlobaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/params")
@AllArgsConstructor
public class parameterController {

    private final ParametreGlobaleService parametreGlobaleService;

    @PostMapping("/save")
    public ResponseEntity<ParameterGlobaleDto> saveParametreGlobale(@RequestBody ParameterGlobaleDto parameterGlobaleDto) {
        ParameterGlobaleDto savedParametre = parametreGlobaleService.saveParametreGlobale(parameterGlobaleDto);
        return new ResponseEntity<>(savedParametre, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParameterGlobaleDto> getParametreGlobale(@PathVariable Long id) throws ParamNotFound {
        ParameterGlobaleDto parametre = parametreGlobaleService.getParametreGlobale(id);
        return new ResponseEntity<>(parametre, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ParameterGlobaleDto> updateParametreGlobale(@PathVariable Long id, @RequestBody ParameterGlobaleDto parameterGlobaleDto) {
        ParameterGlobaleDto updatedParametre = parametreGlobaleService.updateParametreGlobale(id,parameterGlobaleDto);
        return new ResponseEntity<>(updatedParametre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParametreGlobale(@PathVariable Long id) {
        parametreGlobaleService.deleteParametreGlobale(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParameterGlobaleDto>> allParametreGlobale() {
        List<ParameterGlobaleDto> parametres = parametreGlobaleService.allParametreGlobale();
        return new ResponseEntity<>(parametres, HttpStatus.OK);
    }
}
