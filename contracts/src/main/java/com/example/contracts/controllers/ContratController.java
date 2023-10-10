package com.example.contracts.controllers;


import com.example.contracts.dto.ContratDto;
        import com.example.contracts.exceptions.ContractNotFound;
        import com.example.contracts.services.ContratServ;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/contracts")
public class ContratController {

    private final ContratServ contratService;

    @Autowired
    public ContratController(ContratServ contratService) {
        this.contratService = contratService;
    }

    @PostMapping("saveContrat")
    public ResponseEntity<ContratDto> saveContrat(@RequestBody ContratDto contratDto) {
        ContratDto savedContrat = contratService.saveContratParticulier(contratDto);
        return new ResponseEntity<>(savedContrat, HttpStatus.CREATED);
    }

    @GetMapping("/getContrat/{id}")
    public ResponseEntity<ContratDto> getContratById(@PathVariable String id) {
        try {
            ContratDto contratDto = contratService.getContratById(id);
            return new ResponseEntity<>(contratDto, HttpStatus.OK);
        } catch (ContractNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateContrat/{id}")
    public ResponseEntity<ContratDto> updateContrat(@PathVariable String id, @RequestBody ContratDto contratDto) {
        try {
            contratDto.setId(id);
            ContratDto updatedContrat = contratService.updateContrat(contratDto);
            return new ResponseEntity<>(updatedContrat, HttpStatus.OK);
        } catch (ContractNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteContrat/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable String id) {
        contratService.deleteContrat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
