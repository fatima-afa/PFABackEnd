package adria.internship.usersserivce.services;

import adria.internship.usersserivce.dto.PaysDto;
import adria.internship.usersserivce.dto.VilleDto;
import adria.internship.usersserivce.entities.Pays;
import adria.internship.usersserivce.entities.Ville;
import adria.internship.usersserivce.mappers.PaysMapper;
import adria.internship.usersserivce.mappers.VilleMapper;
import adria.internship.usersserivce.repositories.PaysRepository;
import adria.internship.usersserivce.repositories.VilleRepository;
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
public class PaysVilleServiceImpl implements PaysVilleService {
    private VilleMapper villeMapper;
    private PaysMapper paysMapper;
    private VilleRepository villeRepository;
    private PaysRepository paysRepository;

    @Override
    public VilleDto saveVille(VilleDto villeDto) {
        Ville ville=villeMapper.villeDtoToVille(villeDto);
       ville.setPays(paysMapper.paysDtoToPays(villeDto.getPaysDto()));
        //ville.setPays(null);
        Ville savedVille=villeRepository.save(ville);
        log.info("ville saved :"+savedVille);
        return villeMapper.villeToDto(savedVille);
    }

    @Override
    public List<VilleDto> getAllVilles() {
        return villeRepository.findAll()
                .stream()
                .map(ville -> villeMapper.villeToDto(ville))
                .collect(Collectors.toList());

    }

    @Override
    public PaysDto savePays(PaysDto paysDto) {

        Pays pays=paysMapper.paysDtoToPays(paysDto);
        Pays savedPays=paysRepository.save(pays);
        log.info("pays saved :"+savedPays);
        return paysMapper.paysToDto(savedPays);
    }

    @Override
    public List<PaysDto> getAllPays() {
        return paysRepository.findAll()
                .stream()
                .map(pays -> paysMapper.paysToDto(pays))
                .collect(Collectors.toList());
    }
}
