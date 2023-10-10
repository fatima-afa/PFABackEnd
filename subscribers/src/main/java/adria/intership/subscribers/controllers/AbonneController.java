package adria.intership.subscribers.controllers;

import adria.intership.subscribers.dto.AbonneDto;
import adria.intership.subscribers.exceptions.AbonneNotFound;
import adria.intership.subscribers.services.AbonneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abonne")
@AllArgsConstructor
public class AbonneController {

    private final AbonneService abonneService;

    @PostMapping("/save")
    public ResponseEntity<AbonneDto> saveAbonne(@RequestBody AbonneDto abonneDto) {
        AbonneDto savedAbonne = abonneService.saveAbonne(abonneDto);
        return new ResponseEntity<>(savedAbonne, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbonneDto> getAbonne(@PathVariable Long id) throws AbonneNotFound {
        AbonneDto abonne = abonneService.getAbonne(id);
        return new ResponseEntity<>(abonne, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbonneDto> updateAbonne(@PathVariable Long id, @RequestBody AbonneDto abonneDto) throws AbonneNotFound {
        AbonneDto updatedAbonne = abonneService.updateAbonne(abonneDto);
        return new ResponseEntity<>(updatedAbonne, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbonne(@PathVariable Long id) {
        abonneService.deleteAbonne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AbonneDto>> allAbonne() {
        List<AbonneDto> abonnes = abonneService.allAbonne();
        return new ResponseEntity<>(abonnes, HttpStatus.OK);
    }
}
