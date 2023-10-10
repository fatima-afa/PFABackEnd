package com.example.contracts.services;

import com.example.contracts.dto.ContratDto;
import com.example.contracts.entities.Contrat;
import com.example.contracts.exceptions.ContractNotFound;
import com.example.contracts.mappers.BOMapper;
import com.example.contracts.mappers.ContratMapper;
import com.example.contracts.repositories.ContratRepository;
import com.example.contracts.services.ContratServ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class ContratImpl implements ContratServ {
    private ContratRepository contratRepository;
    private ContratMapper contratMapper;
    private BOMapper boMapper;

    @Override
    public ContratDto saveContratParticulier(ContratDto contratDto) {
        Contrat contrat=contratMapper.DtoTocontrat(contratDto);
        contrat.setBo(boMapper.boDtoTobo(contratDto.getBoDto()));
        contrat.setId(UUID.randomUUID().toString());
        Contrat savedContrat=contratRepository.save(contrat);
        log.info("contrat crated  :"+savedContrat);
        return contratMapper.contratToDto(savedContrat);
    }

    @Override
    public ContratDto saveContratEntreprise(ContratDto contratDto) {
        return null;
    }

    @Override
    public ContratDto getContratById(String id) throws ContractNotFound {
        Contrat contrat=contratRepository.findById(id).orElse(null);
        if(contrat==null) throw new ContractNotFound("contract not found");
        return contratMapper.contratToDto(contrat);
    }

    @Override
    public ContratDto updateContrat(ContratDto contratDto) throws ContractNotFound {
    Contrat existingcontrat=contratRepository.findById(contratDto.getId())
            .orElseThrow(()->new ContractNotFound("contract not found"));
            existingcontrat.setStatut(contratDto.getStatut());
            existingcontrat.setTypeContrat(contratDto.getTypeContrat());
            existingcontrat.setDateActivation(contratDto.getDateActivation());
            existingcontrat.setNbMaxTransfert(contratDto.getNbMaxTransfert());
            existingcontrat.setNbMinTransfert(contratDto.getNbMinTransfert());
            existingcontrat.setDateCreation(contratDto.getDateCreation());
            existingcontrat.setBo(boMapper.boDtoTobo(contratDto.getBoDto()));
            contratRepository.save(existingcontrat);
        return contratMapper.contratToDto(existingcontrat);
    }

    @Override
    public void deleteContrat(String id) {
        contratRepository.deleteById(id);
    }
}
