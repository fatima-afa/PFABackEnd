package adria.internship.usersserivce.services;

import adria.internship.usersserivce.dto.AdminDto;
import adria.internship.usersserivce.dto.AgenceDto;
import adria.internship.usersserivce.entities.Admin;
import adria.internship.usersserivce.entities.Agence;
import adria.internship.usersserivce.exceptions.AdminNotFound;
import adria.internship.usersserivce.exceptions.AgenceNotFound;
import adria.internship.usersserivce.mappers.AgenceMapper;
import adria.internship.usersserivce.mappers.VilleMapper;
import adria.internship.usersserivce.repositories.AgenceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class AgenceServiceImpl implements AgenceService {
    private AgenceMapper agenceMapper;
    private AgenceRepository agenceRepository;
    private VilleMapper villeMapper;
    @Override
    public AgenceDto saveAgence(AgenceDto agenceDto) {
        Agence agence=agenceRepository.save(agenceMapper.agenceDtoToAgence(agenceDto));
        agence.setVille(villeMapper.villeDtoToVille(agenceDto.getVilleDto()));
        return agenceMapper.agenceToDto(agence);
    }

    @Override
    public AgenceDto getAgence(Long id) throws AgenceNotFound {
        Agence existingAgence = agenceRepository.findById(id)
                .orElseThrow(() -> new AgenceNotFound("agence not found"));
        return agenceMapper.agenceToDto(existingAgence);
    }
    @Override
    public List<AgenceDto> allAgences() {
        List<Agence> agences=agenceRepository.findAll();
        List<AgenceDto> agenceDtos=agences
                .stream()
                .map(agence -> agenceMapper.agenceToDto(agence))
                .collect(Collectors.toList());
        agenceDtos.forEach(candidatDto -> {
        });
        return agenceDtos;
    }
}
