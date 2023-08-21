package adria.internship.services;

import adria.internship.dto.DeviseDto;
import adria.internship.entities.Devise;
import adria.internship.exceptions.DeviseNotFound;
import adria.internship.mappers.DeviseMapper;
import adria.internship.repositories.DeviseRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class deviseServiceImpl implements deviseService {

    private final DeviseRepository deviseRepository;
    private final DeviseMapper deviseMapper;

    //done
    @Override
    public DeviseDto saveDevise(DeviseDto deviseDto) {
        Devise devise=deviseMapper.deviseDtoToDevise(deviseDto);
        Devise savedDevise= deviseRepository.save(devise);
        return deviseMapper.deviseToDto(savedDevise);
    }

    //done
    @Override
    public DeviseDto getDevise(Long id) throws DeviseNotFound {
//        Optional<Devise> deviseOptional = deviseRepository.findById(id);
//        return deviseOptional.map(deviseMapper::deviseToDto).orElse(null);

        Devise devise=deviseRepository.findById(id).orElse(null);
        if(devise==null)throw new DeviseNotFound("devise not found");
        return deviseMapper.deviseToDto(devise);

    }

    //done
    @Override
    public DeviseDto updateDevise(DeviseDto deviseDto) throws DeviseNotFound {
        Devise existingDevise = deviseRepository.findById(deviseDto.getId())
                .orElseThrow(() -> new DeviseNotFound("Admin not found"));

        existingDevise.setTauxEchange(deviseDto.getTauxEchange());
        existingDevise.setLibelle(deviseDto.getLibelle());
        deviseRepository.save(existingDevise);

        return deviseMapper.deviseToDto(existingDevise);
    }

    //done
    @Override
    public List<DeviseDto> listDevise() {
        List<Devise> devises = deviseRepository.findAll();
        return devises.stream()
                .map(deviseMapper::deviseToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DeviseDto> searchDevise(Long id) {
        return null;
    }
}
