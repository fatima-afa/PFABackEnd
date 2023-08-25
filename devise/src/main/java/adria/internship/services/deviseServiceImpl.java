package adria.internship.services;

import adria.internship.dto.DeviseDto;
import adria.internship.dto.PaysDto;
import adria.internship.entities.Devise;
import adria.internship.entities.Pays;
import adria.internship.exceptions.DeviseNotFound;
import adria.internship.mappers.DeviseMapper;
import adria.internship.mappers.PaysMapper;
import adria.internship.repositories.DeviseRepository;
import adria.internship.repositories.PaysRepository;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class deviseServiceImpl implements deviseService {

    private final DeviseRepository deviseRepository;
    private final DeviseMapper deviseMapper;
    private final PaysRepository paysRepository;
    private final PaysMapper paysMapper;

    //done
//    @Override
    public DeviseDto saveDevise(DeviseDto deviseDto) {
        Devise devise=deviseMapper.deviseDtoToDevise(deviseDto);
        Devise savedDevise= deviseRepository.save(devise);
        return deviseMapper.deviseToDto(savedDevise);
    }

    @Override
    public PaysDto saveDeviseWithPays(PaysDto paysDto) {
        // Vérifier si la devise existe déjà en utilisant son code
        Optional<Devise> existingDevise = deviseRepository.findByCode(paysDto.getDeviseDto().getCode());

        Devise savedDevise;
        if (existingDevise.isPresent()) {
            // Utiliser la devise existante
            savedDevise = existingDevise.get();
        } else {
            // Créer une nouvelle devise
            savedDevise = deviseRepository.save(deviseMapper.deviseDtoToDevise(paysDto.getDeviseDto()));
        }

        // Sauvegarder le pays avec la devise
        Pays pays = paysMapper.paysDtoToPays(paysDto);
        pays.setDevise(savedDevise);
        Pays savedPays = paysRepository.save(pays);

        return paysMapper.paysToDto(savedPays);
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
    public List<PaysDto> listDeviseWithPays() {
        List<Pays> pays = paysRepository.findAll();
        return pays.stream()
                .map(paysMapper::paysToDto)
                .collect(Collectors.toList());
    }

    //done
    @Override
    public DeviseDto patchDevise(Long id, DeviseDto partialDeviseDto) throws DeviseNotFound {
        // Chercher la devise
        Devise existingDevise = deviseRepository.findById(id)
                .orElseThrow(() -> new DeviseNotFound("Devise not found"));

        // Màj statut de l'objet existant avec les valeurs du DTO partiel
        if (partialDeviseDto.getStatutDevise() != null) {
            existingDevise.setStatutDevise(partialDeviseDto.getStatutDevise());
        }
        if (partialDeviseDto.getLibelle() != null) {
            existingDevise.setLibelle(partialDeviseDto.getLibelle());
        }
        if (partialDeviseDto.getTauxEchange() != null) {
            existingDevise.setTauxEchange(partialDeviseDto.getTauxEchange());
        }

        // Enregistrez les modifications dans la base de données
        Devise updatedDevise = deviseRepository.save(existingDevise);

        return deviseMapper.deviseToDto(updatedDevise);
    }

    //done
    @Override
    public PaysDto getDeviseByPays(Long id) throws DeviseNotFound {
        List<Pays> paysList = paysRepository.findAll();

        PaysDto paysWithDevise = paysList.stream()
                .map(paysMapper::paysToDto)
                .filter(pays -> pays.getDeviseDto() != null && pays.getDeviseDto().getId() == id)
                .findFirst()
                .orElse(null);

//        if (paysWithDevise != null) {
//            // Faites quelque chose avec le pays trouvé
//            System.out.println("Pays avec la devise trouvée : " + paysWithDevise.getNom());
//        } else {
//            System.out.println("Aucun pays avec la devise trouvée.");
//        }
        return paysWithDevise;
    }


//    @Override
//    public List<DeviseDto> listDeviseWithPays() {
//        List<Devise> devises = deviseRepository.findAll();
//        List<DeviseDto> deviseDtos = new ArrayList<>();
//
//        for (Devise devise : devises) {
//            DeviseDto deviseDto = deviseMapper.deviseToDto(devise);
//            deviseDtos.add(deviseDto);
//        }
//
//        return deviseDtos;
//    }

    @Override
    public List<DeviseDto> searchDevise(Long id) {
        return null;
    }
}
