package com.example.contracts.services;

import com.example.contracts.dto.ContratDto;
import com.example.contracts.exceptions.ContractNotFound;

public interface ContratServ {
     ContratDto saveContratParticulier(ContratDto contratDto);
     ContratDto saveContratEntreprise(ContratDto contratDto);
     ContratDto getContratById(String id) throws ContractNotFound;
     ContratDto updateContrat(ContratDto contratDto) throws ContractNotFound;
     void deleteContrat(String id);
}
